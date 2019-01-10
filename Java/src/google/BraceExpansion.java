public class BraceExpansion {

	public static String expand(String str) {
		if (null == str || str.equals("") || str.trim().equals("")){
			return "";
		}
		int o,p;
		if ((o = str.indexOf('{')) == -1 || (p = str.indexOf('}')) == -1 || o > p) {
			return str;
		}
		
		int join = str.indexOf("..");
		StringBuilder output = new StringBuilder();
		char c;

		if (join != -1 && o < join && p > join) {
			String st = str.substring(o+1, join);
			String en = str.substring(join+2, p);
			int s=-1,e=-1;
			try {
				s = Integer.parseInt(st);
				e = Integer.parseInt(en);
				StringBuilder seq = new StringBuilder();
				seq.append(str.substring(0,  o));
				seq.append(sequence(s, e));
				seq.append(p+1);
				str = seq.toString();
			} catch (NumberFormatException e1) {
				if (st.length() == 1 && en.length() == 1) {
					StringBuilder seq = new StringBuilder();
					seq.append(str.substring(0,  o));
					seq.append(sequence(st.charAt(0), en.charAt(0)));
					seq.append(p+1);
					str = seq.toString();
				}
			}
		}
		o = str.indexOf('{');
		p = str.indexOf('}');
		if (o < (join=str.indexOf(',')) && p > join){
			if (p == str.length()-1)
				join = -1;
				if (join == -1) {
					for (int i = 1; i < str.length() -1; i++) {
						c = str.charAt(i);
						if (c == ',')
							output.append(' ');
						else
							output.append(c);
					}		
		} else {
			join = p+1;
			String joine = str.substring(join, str.indexOf("{", 1) < 0 ? str.length() : str.indexOf("{", 1));
			if (joine.length() + join == str.length()) {
				output.append(expand(str.substring(1, join-1), joine, " "));
			} else {
				output.append(expand(str.substring(1, join-1), joine, str.substring(str.indexOf('{', 1), str.length())));
			}
		}
	} else {
		output.append(str);
	}
		return output.toString();
	}
	
	private static String expand(String p1, String j, String p2) {
		StringBuilder output = new StringBuilder();
		char c='\0', b='\0';
		StringBuilder sbp1;
		StringBuilder sbp2;
		int i, h=0;
		p2 = expand(p2);
		do {
			sbp1 = new StringBuilder();
			while (h < p1.length() && (c = p1.charAt(h++)) != ',') {
				sbp1.append(c);
			}
			i = 0;
			do {
				sbp2 = new StringBuilder();
				while (i < p2.length() && (b = p2.charAt(i++)) != ' ') {
					sbp2.append(b);
				}
				output.append(sbp1);
				output.append(j);
				output.append(sbp2);
				if (b == ' ')
					output.append(' ');
			} while (i < p2.length());
			if (c == ',')
				output.append(' ');
		} while (h < p1.length());
		
		return output.toString();
	}
	
	private static StringBuilder sequence(int s, int e) {
		System.out.println(s + " :: " + e);
		StringBuilder output = new StringBuilder('{');
		while (s < e) {
			output.append(s);
			output.append(',');
			++s;
		}
		output.append(s);
		output.append('}');
		return output;
	}
	
	private static StringBuilder sequence(char s, char e) {
		StringBuilder output = new StringBuilder('{');
		while (s < e) {
			output.append((char)s);
			output.append(',');
			++s;
		}
		output.append((char)s);
		output.append('}');
		return output;
	}
}
