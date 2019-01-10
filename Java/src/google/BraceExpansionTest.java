import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BraceExpansionTest {

	@Test
	public void simpleExpansion() {
		assertEquals("a b c", BraceExpansion.expand("{a,b,c}"));
	}
	
	@Test
	public void simpleExpansion2() {
		assertEquals("a b c_123", BraceExpansion.expand("{a,b,c_123}"));
	}
	
	@Test
	public void simple2Expansion() {
		assertEquals("aa bb cc", BraceExpansion.expand("{aa,bb,cc}"));
	}
	
	@Test
	public void doubleExpansion() {
		assertEquals("a1 a2 a3 b1 b2 b3 c1 c2 c3", BraceExpansion.expand("{a,b,c}{1,2,3}"));
	}
	
	@Test
	public void double2Expansion() {
		assertEquals("aa1 aa2 aa3 bb1 bb2 bb3 cc1 cc2 cc3", BraceExpansion.expand("{aa,bb,cc}{1,2,3}"));
	}
	
	@Test
	public void double22Expansion() {
		assertEquals("aa11 aa22 aa33 bb11 bb22 bb33 cc11 cc22 cc33", BraceExpansion.expand("{aa,bb,cc}{11,22,33}"));
	}
	
	@Test
	public void doubleExpansionJoin() {
		assertEquals("a_1 a_2 a_3 b_1 b_2 b_3 c_1 c_2 c_3", BraceExpansion.expand("{a,b,c}_{1,2,3}"));
	}
	
	@Test
	public void doubleExpansionMissing() {
		assertEquals("a_123} b_123} c_123}", BraceExpansion.expand("{a,b,c}_123}"));
	}
	
	@Test
	public void double2ExpansionMissing() {
		assertEquals("aa_123} bb_123} cc_123}", BraceExpansion.expand("{aa,bb,cc}_123}"));
	}
	
	@Test
	public void tripleExpansion() {
		assertEquals("a1x a1y a1z a2x a2y a2z a3x a3y a3z b1x b1y b1z b2x b2y b2z b3x b3y b3z c1x c1y c1z c2x c2y c2z c3x c3y c3z",
				BraceExpansion.expand("{a,b,c}{1,2,3}{x,y,z}"));
	}
	
	@Test
	public void quadrupleExpansion() {
		assertEquals("a1x4 a1x5 a1x6 a1y4 a1y5 a1y6 a1z4 a1z5 a1z6 a2x4 a2x5 a2x6 a2y4 a2y5 a2y6 a2z4 a2z5 a2z6 a3x4 a3x5 a3x6 a3y4 a3y5 a3y6 a3z4 a3z5 a3z6 b1x4 b1x5 b1x6 b1y4 b1y5 b1y6 b1z4 b1z5 b1z6 b2x4 b2x5 b2x6 b2y4 b2y5 b2y6 b2z4 b2z5 b2z6 b3x4 b3x5 b3x6 b3y4 b3y5 b3y6 b3z4 b3z5 b3z6 c1x4 c1x5 c1x6 c1y4 c1y5 c1y6 c1z4 c1z5 c1z6 c2x4 c2x5 c2x6 c2y4 c2y5 c2y6 c2z4 c2z5 c2z6 c3x4 c3x5 c3x6 c3y4 c3y5 c3y6 c3z4 c3z5 c3z6",
				BraceExpansion.expand("{a,b,c}{1,2,3}{x,y,z}{4,5,6}"));
	}
	
	@Test
	public void simpleLiteral() {
		assertEquals("{abc}", BraceExpansion.expand("{abc}"));
	}
	
	@Test
	public void missing1() {
		assertEquals("{abc", BraceExpansion.expand("{abc"));
	}
	
	@Test
	public void missing2() {
		assertEquals("abc}", BraceExpansion.expand("abc}"));
	}
	
	@Test
	public void missing3() {
		assertEquals("a,b,c}_123}", BraceExpansion.expand("a,b,c}_123}"));
	}
	
	@Test
	public void sequenceAlphaExpansion() {
		assertEquals("a b c d e f g h", BraceExpansion.expand("{a..h}"));
	}
	
	@Test
	public void sequenceAlphaCapExpansion() {
		assertEquals("A B C D E F G H", BraceExpansion.expand("{A..H}"));
	}
	
	@Test
	public void sequence2AlphaExpansionIsLiteral() {
		assertEquals("{a..h..z}", BraceExpansion.expand("{a..h..z}"));
	}
	
	@Test
	public void sequenceNumExpansion() {
		assertEquals("1 2 3 4 5", BraceExpansion.expand("{1..5}"));
	}
	
	@Test
	public void sequenceMixExpansion1() {
		assertEquals("a ` _ ^ ]  [ Z Y X W V U T S R Q P O N M L K J I H", BraceExpansion.expand("{a..H}"));
	}
	
	@Test
	public void sequenceMixExpansion2() {
		assertEquals("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [  ] ^ _ ` a b c d e f g h",
				BraceExpansion.expand("{A..h}"));
	}
	
	@Test
	public void sequenceMixExpansion3() {
		assertEquals("{0..Z}", BraceExpansion.expand("{0..Z}"));
	}
	
	@Test
	public void sequenceDoubleExpansion() {
		assertEquals("1a 1b 1c 1d 1e 1f 1g 1h 2a 2b 2c 2d 2e 2f 2g 2h 3a 3b 3c 3d 3e 3f 3g 3h 4a 4b 4c 4d 4e 4f 4g 4h 5a 5b 5c 5d 5e 5f 5g 5h",
				BraceExpansion.expand("{1..5}{a..h}"));
	}
}
