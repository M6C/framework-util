package framework.ressource.util.compiler;

/*
 *  Copyright 1999-2004 The Apache Sofware Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import java.util.Hashtable;

/**
 * @author  Costin Manolache
 */
public class UtilJsp {

	Hashtable attributes = new Hashtable();
	String args[];
	String installDir;
	ClassLoader parentL;

	public UtilJsp() {
	}

	//-------------------- Properties --------------------

	/**
	 * @param args  the args to set
	 * @uml.property  name="args"
	 */
	public void setArgs(String args[]) {
		this.args = args;
	}

	public void setInstall(String s) {
		installDir = s;
	}

	// -------------------- execute --------------------
	public void execute() throws Exception {
		if (args != null)
			processArgs(args);
//		org.apache.jasper.JspC.main(args);
	}

	// -------------------- Command-line args processing --------------------

	/** Process arguments - set object properties from the list of args.
	 */
	public boolean processArgs(String[] args) {
		try {
			if (args.length > 0 && "jspc".equalsIgnoreCase(args[0])) {
				String args1[] = new String[args.length - 1];
				System.arraycopy(args, 1, args1, 0, args.length - 1);
				args = args1;
			}
			setArgs(args);
			// return IntrospectionUtils.processArgs( this, args,getOptions1(),
			// 		   null, getOptionAliases());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/** Callback from argument processing
	 */
	public void setProperty(String s, Object v) {
		if (dL > 0)
			debug("Generic property " + s);
		attributes.put(s, v);
	}

	/** Called by Main to set non-string properties
	 */
	public void setAttribute(String s, Object o) {
		if ("install".equals(s))
			setInstall((String) o);
		else if ("args".equals(s))
			args = (String[]) o;
		else if ("parentClassLoader".equals(s))
			parentL = (ClassLoader) o;
		attributes.put(s, o);
	}

	// -------------------- Main --------------------

	public static void main(String args[]) {
		try {
			UtilJsp task = new UtilJsp();
			task.setArgs(args);
			task.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	private static int dL = 0;
	private void debug(String s) {
		System.out.println("Jspc: " + s);
	}
}
