package Efsm2ModelJUnit.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Efsm.efsm.EFSM;
import Efsm.efsm.EfsmFactory;
import Efsm.efsm.EfsmPackage;

import java.util.Random;

import bsh.EvalError;
import bsh.Interpreter;

public class Efsm2JUnit {
	static EfsmFactory efsmFactory = EfsmFactory.eINSTANCE;
	static StringBuilder jUnit = new StringBuilder();
	static int ord;
	static String param = "";
	static String dado;
	static int intDadoString;
	static boolean retorno;
	static boolean guarda;
	static String retornoString;
	static String teste;
	static String get;
	static boolean thisOk;
	static int q;
	static Interpreter interpreter = new Interpreter();
	public static void main(String[] args) throws IOException, EvalError {
		EFSM efsm = efsmFactory.createEFSM();
		String pathload = "../Sd2Efsm/";
		String loadFile = pathload + "Modelo.efsm";
		
		efsm = loadModel(loadFile);

		String nameArq = efsm.getName() + "JUnit";
		String pathSaveFile = "Files/";
		String saveFile = pathSaveFile + nameArq + ".java";

		FileWriter saveFileJava = new FileWriter(saveFile);
		PrintWriter includeFileJava = new PrintWriter(saveFileJava);
        jUnit.append("import static org.junit.Assert.*;");
        jUnit.append("\n");
        jUnit.append("import java.util.Date;");
        jUnit.append("\n");
        jUnit.append("import org.junit.Test;");
        jUnit.append("\n\n");
		jUnit.append("public class "+nameArq+"{");		
        jUnit.append("\n");
        ord = 1;
        Random random = new Random();
		efsm.getTransitions().forEach(trans-> {
			if (trans.getGuard() != "") {
				jUnit.append("\t@Test\n");
				jUnit.append("\tpublic void test"+trans.getEvent().getName().substring(0, 1).toUpperCase()+trans.getEvent().getName().substring(1)+ord+"(){\n");
				jUnit.append("\t\t"+trans.getEvent().getClass_()+" "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+" = new "+trans.getEvent().getClass_().toString()+"();\n");
				thisOk = trans.getGuard().contains("this");
				if (trans.getEvent().getReturn().equals("boolean") && thisOk == false) {
					if (trans.getAction().startsWith("!")) {
						if (trans.getAction().contains("true")) {
							retorno = false;
							q = 1;
						}
						if (trans.getAction().contains("false")) {
							retorno = true;
							q = 1;
						}
					}
					else {
						if (trans.getAction().contains("true")) {
							retorno = true;
							q = 1;
						}
						else {
							if (trans.getAction().contains("false")) {
								retorno = false;
								q = 1;
							}
							else {
								retorno = true;
								q = 2;
							}
						}
					}
										
					guarda = ! (retorno);
					intDadoString = 1;
					for(int i = 1; i <= q; i++) {
						while (guarda != retorno) {
							teste = trans.getEvent().getReturn()+" output = "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
									"."+trans.getEvent().getName()+"(";
							get = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
									"."+trans.getEvent().getName()+"(";
							param = "";
							trans.getEvent().getArgs().forEach(arg->{
								if (arg.getArgType().equals("int"))
									dado = Integer.toString(random.nextInt(10));
								if (arg.getArgType().equals("String")) {
									if (intDadoString == 1) {
										if (trans.getGuard().contains("equals"))
											dado = trans.getGuard().substring(trans.getGuard().indexOf("equals")+7, trans.getGuard().indexOf(")"));
										else
											if (trans.getGuard().contains("contains"))
												dado = trans.getGuard().substring(trans.getGuard().indexOf("contains")+10, trans.getGuard().indexOf(")")-1);
											else
												dado = "";
									}
									if (intDadoString == 2)
										dado = "1";
									if (intDadoString == 3)
										dado = "A";
									if (intDadoString >= 4 && intDadoString <= 13) {
										if (intDadoString == 4)
											dado = "1";
										else
											dado = dado+"1";
									}
									if (intDadoString >= 14 && intDadoString <= 23) {
										if (intDadoString == 14)
											dado = "A";
										else
											dado = dado+"A";
									}
									if (intDadoString >= 24 && intDadoString <= 33) {
										if (intDadoString == 24)
											dado = "A";
										else
											dado = dado+"1";
									}
									if (intDadoString >= 34 && intDadoString <= 43) {
										if (intDadoString == 34)
											dado = "1";
										else
											dado = dado+"A";
									}
								}
								if (param.equals("")) {
									if (arg.getArgType().equals("String"))
										param = arg.getArgType()+" "+arg.getArgName()+" = \""+dado+"\";";
									else
										param = arg.getArgType()+" "+arg.getArgName()+" = "+dado+";";
								}
								else {
									if (arg.getArgType().equals("String"))
										param = param + arg.getArgType()+" "+arg.getArgName()+" = \""+dado+"\";";
									else	
										param = param + arg.getArgType()+" "+arg.getArgName()+" = "+dado+";";
								}
								if (teste.endsWith("(")) {
									if (arg.getArgType().equals("String"))
										teste = teste+"\""+dado+"\"";
									else
										teste = teste+dado;
								}
								else {
									if (arg.getArgType().equals("String"))
										teste = teste+", \""+dado+"\"";
									else
										teste = teste+", "+dado;
								}
							});
							teste = teste+");";
							try {
								Object res = interpreter.eval(param+trans.getGuard());
								System.out.println(res+" "+param+" "+trans.getGuard());
								if (res.equals(true))
									guarda = true;
								else
									guarda = false;
							} catch (EvalError e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							intDadoString++;
						}
						jUnit.append("\t\t"+teste+"\n");
						
						if (retorno)
							jUnit.append("\t\tassertTrue(output);\n");
						else
							jUnit.append("\t\tassertFalse(output);\n");
						jUnit.append("\t}\n\n");
						if (q == 2) {
							retorno = false;
							if (i == 1) {
								ord++;
								jUnit.append("\t@Test\n");
								jUnit.append("\tpublic void test"+trans.getEvent().getName().substring(0, 1).toUpperCase()+trans.getEvent().getName().substring(1)+ord+"(){\n");
								jUnit.append("\t\t"+trans.getEvent().getClass_()+" "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+" = new "+trans.getEvent().getClass_().toString()+"();\n");
							}
						}
					}
				}
				
				if (trans.getEvent().getReturn().equals("boolean") && thisOk == true && !trans.getInput().getName().substring(0, 3).equals("get")) {
					if (trans.getAction().startsWith("!")) {
						if (trans.getAction().contains("true")) {
							retorno = false;
							q = 1;
						}
						if (trans.getAction().contains("false")) {
							retorno = true;
							q = 1;
						}
					}
					else {
						if (trans.getAction().contains("true")) {
							retorno = true;
							q = 1;
						}
						else {
							if (trans.getAction().contains("false")) {
								retorno = false;
								q = 1;
							}
							else {
								retorno = true;
								q = 2;
							}
						}
					}
					for(int i = 1; i <= q; i++) {
						teste = trans.getEvent().getReturn()+" output = "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
								"."+trans.getEvent().getName()+"(";
						param = "";
						trans.getEvent().getArgs().forEach(arg->{
							if (retorno == true)
								dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()";
							else {
								if (arg.getArgType().equals("String"))
									dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()+"+"\"A\"";
								else
									dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()+"+"1";
							}						
							if (teste.endsWith("("))
								teste = teste+dado;
							else
								teste = teste+", "+dado;
						});
						teste = teste+");";
						jUnit.append("\t\t"+teste+"\n");
						if (retorno == true)
							jUnit.append("\t\tassertTrue(output);\n");
						else
							jUnit.append("\t\tassertFalse(output);\n");
						jUnit.append("\t}\n\n");
						
						if (q == 2) {
							retorno = false;
							if (i == 1) {
								ord++;
								jUnit.append("\t@Test\n");
								jUnit.append("\tpublic void test"+trans.getEvent().getName().substring(0, 1).toUpperCase()+trans.getEvent().getName().substring(1)+ord+"(){\n");
								jUnit.append("\t\t"+trans.getEvent().getClass_()+" "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+" = new "+trans.getEvent().getClass_().toString()+"();\n");
							}
						}
					}
				}

				if (trans.getInput().getName().substring(0, 3).equals("get")) {
					if (trans.getAction().startsWith("!")) {
						if (trans.getAction().contains("true")) {
							retorno = false;
							q = 1;
						}
						if (trans.getAction().contains("false")) {
							retorno = true;
							q = 1;
						}
					}
					else {
						if (trans.getAction().contains("true")) {
							retorno = true;
							q = 1;
						}
						else {
							if (trans.getAction().contains("false")) {
								retorno = false;
								q = 1;
							}
							else {
								retorno = true;
								q = 2;
							}
						}
					}
					
					for(int i = 1; i <= q; i++) {
						teste = trans.getEvent().getReturn()+" output = "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
								"."+trans.getEvent().getName()+"(";
						get = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
								"."+trans.getEvent().getName()+"(";
						param = "";
						trans.getEvent().getArgs().forEach(arg->{
							if (thisOk == true) {
								if (retorno == true) {
									if (arg.getArgType().equals("String"))
										dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()";
									else
										dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()";
								}
								else {
									if (arg.getArgType().equals("String"))
										dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()+"+"\"A\"";
									else
										dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+".get"+arg.getArgName().substring(0, 1).toUpperCase()+arg.getArgName().substring(1)+"()+"+"1";									
								}
									
							}
							else {
								if (arg.getArgType().equals("String"))
									dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+"()";
								else
									dado = trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+"()";							
							}
							if (teste.endsWith("(")) {
								teste = teste+dado;
								get = get+dado;
							}
							else {
								teste = teste+", "+dado;
								get = get+", "+dado;
							}
						});
						teste = teste+");";
						get = get+")";
						jUnit.append("\t\t"+teste+"\n");
						
						if (retorno == true) {
							if (trans.getEvent().getReturn().equals("boolean")) {
								jUnit.append("\t\tif (output)\n");
								jUnit.append("\t\t\tassertTrue(output);\n");
								jUnit.append("\t\telse\n");
								jUnit.append("\t\t\tassertFalse(output);\n");
								jUnit.append("\t}\n\n");
							}
							else {
								jUnit.append("\t\tassertEquals(output,"+get+");\n");
								jUnit.append("\t}\n\n");								
							}
						}
						else {
							if (trans.getEvent().getReturn().equals("boolean")) {
								jUnit.append("\t\tassertFalse(output);\n");
								jUnit.append("\t}\n\n");
							}
							else {
								jUnit.append("\t\tassertEquals(output,null);\n");
								jUnit.append("\t}\n\n");								
							}
						}
						
						if (q == 2) {
							retorno = false;
							if (i == 1) {
								ord++;
								jUnit.append("\t@Test\n");
								jUnit.append("\tpublic void test"+trans.getEvent().getName().substring(0, 1).toUpperCase()+trans.getEvent().getName().substring(1)+ord+"(){\n");
								jUnit.append("\t\t"+trans.getEvent().getClass_()+" "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+" = new "+trans.getEvent().getClass_().toString()+"();\n");
							}
						}
					}
				}
				
				if (trans.getEvent().getReturn().equals("String") && thisOk == false && !trans.getInput().getName().substring(0, 3).equals("get")) {
					guarda = false;
					while (guarda != true) {
						retornoString = trans.getAction().substring(trans.getAction().indexOf("equals")+7, trans.getAction().indexOf(")"));
						System.out.println(retornoString);
						teste = trans.getEvent().getReturn()+" output = "+trans.getEvent().getClass_().substring(0, 1).toLowerCase()+trans.getEvent().getClass_().substring(1)+
								"."+trans.getEvent().getName()+"(";
						param = "";
						trans.getEvent().getArgs().forEach(arg->{
							if (arg.getArgType().equals("int"))
								dado = Integer.toString(random.nextInt(10));
							if (trans.getGuard().contains("contains")) {
								dado = trans.getGuard().substring(trans.getGuard().indexOf("contains")+10, trans.getGuard().indexOf(")")-1);
								dado = "\""+dado+"\"";
							}
							if (param.equals(""))
								param = arg.getArgType()+" "+arg.getArgName()+" = "+dado+";";
							else
								param = param + arg.getArgType()+" "+arg.getArgName()+" = "+dado+";";
							if (teste.endsWith("("))
								teste = teste+dado;
							else
								teste = teste+", "+dado;
						});
						teste = teste+");";
						if (trans.getGuard().contains("contains")){
							guarda = true;	
						}
						else {
							try {
								Object res = interpreter.eval(param+trans.getGuard());
								System.out.println(res+" "+param+" "+trans.getGuard());
								if (res.equals(true))
									guarda = true;
								else
									guarda = false;
							} catch (EvalError e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					jUnit.append("\t\t"+teste+"\n");
					jUnit.append("\t\tassertEquals(output,"+retornoString+");\n");
					jUnit.append("\t}\n\n");
				}
				ord++;
			}
		});
        
        jUnit.append("}");
		includeFileJava.print(jUnit);
		saveFileJava.close();
	}

	private static EFSM loadModel(String loadFile) {

		EPackage.Registry.INSTANCE.put(EfsmPackage.eNS_URI, EfsmPackage.eINSTANCE);

		EFSM efsm = efsmFactory.createEFSM();
		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("efsm",
				new XMIResourceFactoryImpl());

		URI fileURI = URI.createURI(loadFile);

		Resource resource = resourceSet.getResource(fileURI, true);

		try {

			resource.load(null);
			efsm = (EFSM) resource.getContents().get(0);
			System.out.println("Load: " + loadFile);
			// resource.save(System.out, Collections.EMPTY_MAP);
			return efsm;

		} catch (IOException e) {
			System.out.println("failed to read " + fileURI);
		}

		return null;

	}
}
