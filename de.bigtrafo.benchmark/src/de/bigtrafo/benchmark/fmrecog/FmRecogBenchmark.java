/**
 * <copyright>
 * Copyright (c) 2010-2012 Henshin developers. All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 which 
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package de.bigtrafo.benchmark.fmrecog;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.BasicApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import de.bigtrafo.benchmark.ocl.OclBenchmark;
import de.bigtrafo.benchmark.util.LoadingHelper;
import de.bigtrafo.benchmark.util.MaintainabilityBenchmarkUtil;
import de.bigtrafo.benchmark.util.RuntimeBenchmarkReport;
import de.imotep.featuremodel.variability.metamodel.FeatureModel.FeatureModel;
import de.imotep.featuremodel.variability.metamodel.FeatureModel.FeatureModelPackage;

public class FmRecogBenchmark {
	
	private static final String FILE_PATH = "fmrecog/";
	private static final String FILE_PATH_RULES = "rules";
	private static final String FILE_PATH_INSTANCE = "instances/";
	private static final String FILE_PATH_OUTPUT = "output/";
	private static final String FILE_NAME_DIFF = "/1_x_2_FeatureModelMatcher_lifted_post-processed.symmetric";
	private static final String FILE_NAME_MODEL1 = "/1.featuremodel";
	private static final String FILE_NAME_MODEL2 = "/2.featuremodel";

	enum mode {
		CLASSIC
	}

	/**
	 * Relative path to the model files.
	 */
	public static final String PATH = "fmrecog";

	public static void main(String[] args) {
//		// Uncomment the following lines to print statistics about the transformation. 
//		Module module = loadModule();
//		MaintainabilityBenchmarkUtil.runMaintainabilityBenchmark(module); 
		
		String[] examples = {
				"sizevar_100_var1",
				"sizevar_100_var2",
				"sizevar_100_var3",
				"sizevar_200_var1",
				"sizevar_200_var2",
				"sizevar_200_var3",
				"sizevar_300_var1",
				"sizevar_300_var2",
				"sizevar_300_var3", 
				
		};
		int runs = 1;
		RuntimeBenchmarkReport reporter = new RuntimeBenchmarkReport(OclBenchmark.class.getSimpleName(), FILE_PATH + FILE_PATH_OUTPUT);
		reporter.start();
		for (String example : examples) {
			System.out.println("Example " + example);
				for (int i = 0; i < runs; i++) {
					runPerformanceBenchmark(PATH,  example, reporter);
					System.gc();
				}
		}
	}


	/**
	 * Run the performance benchmark.
	 * 
	 * @param path
	 *            Relative path to the model files.
	 * @param iterations
	 *            Number of iterations.
	 */
	public static void runPerformanceBenchmark(String path,  String exampleID, RuntimeBenchmarkReport runtimeBenchmarkReport) {
		runtimeBenchmarkReport.addEntryHeader(exampleID);
		Module module = loadModule();
		HenshinResourceSet rs = (HenshinResourceSet) module.eResource().getResourceSet();
		// Load the model into a graph:
		EObject instance = rs.getEObject(FILE_PATH_INSTANCE + exampleID
				+ FILE_NAME_DIFF);
		FeatureModel model1 = (FeatureModel) rs.getEObject(FILE_PATH_INSTANCE
				+ exampleID + FILE_NAME_MODEL1);
		FeatureModel model2 = (FeatureModel) rs.getEObject(FILE_PATH_INSTANCE
				+ exampleID + FILE_NAME_MODEL2);
		EGraph graph = new EGraphImpl(FeatureModelPackage.eINSTANCE);
		graph.addGraph(instance);
		graph.addGraph(model2);
		graph.addGraph(model1);

		// Create an engine and rule applications:

		long startTime = System.currentTimeMillis();

		ApplicationMonitor monitor = new BasicApplicationMonitor();
		monitor = new BasicApplicationMonitor();
		int graphInitially = graph.size();

		Engine engine = new EngineImpl();
		engine.getOptions().put(Engine. OPTION_SORT_VARIABLES, false);
		
		System.gc();
		startTime = System.currentTimeMillis();
		
		for (Unit unit : module.getUnits()) {
			if (unit instanceof Rule) {
				Rule rule = (Rule)unit;
				Iterator<Match> it = engine.findMatches(rule, graph, null)
						.iterator();
				while (it.hasNext()) {
					Match match = it.next();
					RuleApplication application = new RuleApplicationImpl(
							engine, graph, rule, match);
					application.execute(monitor);
				}
			}
		}
		

		long runtime = (System.currentTimeMillis() - startTime);
		int graphChanged = graph.size();
		
		runtimeBenchmarkReport.finishEntry(graphInitially, graphChanged, runtime);
	}


	private static Module loadModule() {
		FeatureModelPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("symmetric", new XMIResourceFactoryImpl());
		m.put("featuremodel", new XMIResourceFactoryImpl());

		// Create a resource set with a base directory:
		HenshinResourceSet rs = new HenshinResourceSet(FILE_PATH);
		EPackage diffPackage = rs.registerDynamicEPackages("Symmetric.ecore")
				.get(0);
		rs.getPackageRegistry().put(diffPackage.getNsURI(), diffPackage);
		rs.getPackageRegistry().put(FeatureModelPackage.eINSTANCE.getNsURI(),
				FeatureModelPackage.eINSTANCE);

		Module module = LoadingHelper.loadAllRulesAsOneModule(rs, FILE_PATH, FILE_PATH_RULES);

		return module;
	}

}
