package main.java;

import java.util.ArrayList;
import java.util.List;

public class Day08_1 {

	private static final String INPUT = "202222220022222222221222222020222222222220222122222202222222222002222222220222202222220202202202022222220221202222220222222122222222022222221022222220202222220122222222221222222122222222222220222222222202222222222202222222222222222222222202202222222222221220222222222222222122222222122222221122222221222222220122222222221222222022222222222220222022222222222222222222222222221222212222220202202222022222222221222222222222222022222212122222222122222220202222222022222222221222222121222222222222222022222202222222222002222222220222222222221212212222122222222222222222220222222222222212122222222122222221222222221022222222222222222120222222222221222222222202222222222212222222220222212222222212212212222222221220212222220222222022222212122222222022222220212222221122222222220222222122222222222221222022222212222222221122222222221222212222221212212202222222220221222022222222122021222212222222221122202221202222222222222222221222222220222222222220222122222212222222220012222222222222212222222222212202122222221220212222222222222020222212122222222222202222202222221222222222221222222220222222222221222222222202222220221222222222221222212222220212202202022222220222222122220222122022222202122222220022212220212222220222222222220222222021222222222220222222222202222222221212222222220222222122220222222212122222221221222222221222022121222212122222220222212221202222220222222222220222222121222222222220222222222202222221220222222222220222202222221202212222121222222222202222221222222222222202022222221222222221212222222222222222222222222122222222222220222222222222222222222012222222220222212222222212222202220222221220222022220222122021222202222222220022212222222222221222222222221222222022222222222220222022222202222220221022222222220222212022222212202202122222220221222022221222122020222212022222221122212222222222222122222222221222222021222222222220222122222222222222220102222222221222222222221202202212220222221220202222221222222120222222122222222222212221212222221222222222220222222020222222222220222022222202222222220002222222222222202222220222202222020222222222222022222222222220222202222222220222202221212222222122222222222222222220222222222220222122222222222220220222222222220222202222220202212212220222220221202122221222202020222202022222221222212222222222222222222222221222222121222222222220222222222212222222220212222222220222212122220202222212120222222221212222222222222020222212222222220022212221222222220022222222220222222122222222222221222122222222222221222202222222220222202222220222202202122222220220212022222222222121222212222222222122202220222222221222222222222222222121222222222220222122222202222221221022222022222222212022221222222222022222221222202122220222002221222202222222222122202221222222221022222222220222222121222222222221222222222222222222221012222222221222212122222222202222021222220220222022220222122021222202212222221222212221222222221122222222220222222020222222222221222122222212222222220202222122221222222122221222212222121222221222212022021222002022222202102222221122212222212222220022222222220222222022222222022220222022222202222221221012222222220222212122222212222222101222222222201122020222122220222202212222222022222222212221222122222222221222222022222222122220222122222202212221221222222222222222222122221222202212112222220220212222121222112020222222222222222222222222202222222122222222222222222121222222022222222222222202222220221122222022221222202022222202222212002222220220200222120222012021222202222222220022212221212220220122222222222222222222222222022220222022222222212220222122222222220222222122221222112202200222221220200222022222202120222212122222220222221221202220222022212222221222222120222222122222222222222202202220221212222122222222222122221212102202202222222221221022020222212222222202102222220122211221212220222222202222220222222120222222122221222022222212202222220102222122221222222022220212122202122222221221210022220222222122222202122222222022222222222220221122222222220222222220222222122222222222222202212222221022222122220222212022211222212212100222222222211222222222212221222222122222221022201222212222221022222222222222222020220222222220222122222212202221222122222222220222222222211212122202221222221222221222220222202220222202012222220022211222222222221222212222220222222122220222022220222222222212212222221102222222222222212122201212112212222222222221210222221222212121222222112222221022220221222222220022222222221222222222221222022220222222222222212222222111222022221222212022212212122202222222220222221122220222002221222212222222221222212222102220220022212222221222222122220222222220222222222222202220221100222022222222202022201212212222111222220222200120022222202220222202022222221222211220022222221222222222220221222221220222022220222022222212202222221222222122221222212122200212112222111222222221220120222222002121222212002222220022222221122220220222222222221222222122222222022221222122222222212220222012222022221222222122212212222202100022222220200022022222022021222222022222220022202222222222222022202222221220222221221222022222222122222222212221221112222022221222202222022222102222102022220222201220222222110022222222012222221122222221222220120222222222221220222221220222022222222022222202222222221200222122220222221220210212102222002022221221201122120222202220222222112222221222221220222220020222212222220221222220222222022220222022222202222220221200222222220222200122120212212212112022221220212122222222212022222202222222221222202221212222021122202222221221222021220222122220222222222212212220222112222222022222212022002222012212102122222122211122121222220222212212202222222022200221212222122122202122220221222220220222022220222222222222222220221111222222021222222120022212112212012122222100222222120222022121202212002222221022221221112222120122222122220221222020222222022220222022222222202221220020222022222222201222021202022212102022220211210221122222220120222212022222221222211220222220220022202122222220222220220222022220202222222222202220220212222122022222212020101212211222002012220020222120021222001022212212012222220022212221022220120122222222221221222221222222022220212022222212202220222112222222021222222221002222001212122202221222222220120222110121212222212222221122220220102220222122202022221220022022222222122222212222222212202220221221222222020222210021020212102212212212220000212222021222001022212202212222221021202220212220220122202122221220222220221222222220202122222212222221221100222022222222220221121212000202222112222102222121022222122120212222102222222121211221012222020122202122220222022122220222122221202022222212222220222201222022221222212022202202111222101002221222210222021222002221202202022222222221220222212222221122212022221220122121221222022222212222222222212221222021222222022222201221000202120222101102221112210020020222201220222212112222221020222221102222122022222022220220022021221222022220212222222222202222220222222022122222210221202022112222200012220010210122020222101120222212102222222221212220122220222222202022221221122120220222222220122122222222202222220112222022221222221122212012020002212012220001221022122222200022212202202222222220202220202220220122202120221222222222202222122220012022222222222220220212222122021222202022201202012112022022221102220122021222222122202212022222222022202221122220221222212021221222222022210222022220022022222212212221220201222222120222211120102122121112112122221121222121121222000222222212122222220120202220202222021122220021221221022122220222022221012022222202202222221221222222121222200121021022020112022002222110200020020222111022222212102222221122210220222220222022202121220221222120211222122222102022222212222222220200222222221222221120202222110202212002220010201201222222111022202202112222220121212222222221220222220122220222022122211222222220022222222202212222222100222022022122220221201122201002020012221022201110220222111021222202112222222020211222212220021022202221222221022122221222022221002022222222212222220010222222120222220122012212102112202202221211220120220222021021212202222222220021211222002221022122200222221220222221212222022221022022222222212222222010222022122122222020120222002002212102222002222221221222101120212202202222221222212221112222120222221021221220222022211222122221102222222202212222220121222122121122200222012202121002201022220120011201221222222221222212112222222220200222012222221122211220221220122021201222222220112222222202222221221222222222122022200022221112022002122002222020111220022222020121212212222222222220221222022220020122211120201222022220212222022220022222222222202221221222222222122222211020021012010022010122221021000021222222002122212222122222220021201220202221122122212122212221122021210222222221122022222212212220221201222122020122201122212102220212000122220211002220122222010020222212002222220222220222122220220022200221210222122020212222122221022022222222222222222022222022222122221212221122112022202002222201022121221222211222201222112222222022212221022222120122221221211221122222222222122220212020222202212220222122222022222122200220202222111122122122222212210101221222000220211222102222222022211222212222222022202022210220222020211222122220212222222222200222220021222222122122212120102122121012022212222100022122021222100020200202112222220121222222222222021122212221222222022022211222222222002221222222212222221112222122121022222020111222010112111212221221002220222222210220212222112220222022220221222220121022211122220221122021211122022222002020222222202220221100222122022022220200100202102122001222221211012102122222201222211202122220221122200221122221022222220120212222122022212022122221202120222222201222222021222122221222212200121112201212012122222101010210221222222221201212122222221121200222012220120022211021202222222220200222222221222022222212211222221211222222222022220121012202020202001212222202111121022222021122201212202221221022220222212220222222201120201222022122222222222221122120222202212222221101222022121222221211021222012002221202220200222211221222110222210202002121222022222221102220121222222222222221122120202022022220202021222202211222220021222122222122211000110112221012112122221021222122021222201222212222012022220221201221202220022122220121212220222121221222222221112122222202211222221211220122022222221102202122000212001102221222022100122222212022200222022221222220200221002221122022201222200220022021211022122220122122222202210222221201221122222222202222001012020202020102220012121202021222000120210212102021220122212221212220222222211222202222022221200122122222102022222212211220221012222222021122221222010222002012120122221100010000121222121020201002202220222220211222122221220222201120202221222222211122122021022122222212211222222212222022020122220220022212200102001112221100101221221222100121220102202022221122202220022221022022200020210220122020200222022020022022222202212222221000220222121222022220002202210212100222220210002102020222011222201022202022222020222221202221022022220021211220222021212022022021202022222012222220221202221022022022000022000222222102011012222010100221110222000121212022202122221020220220002220220022221021222220022022210222122220122222222002202220220101220222110022111001201222022012111022221222101211101222200020210112102222221021210221102222222122200020221220122220211122222021102122222022201222222001220022000122020000012222021202020220221020000012000222220221212002222020221121221120212221222122201222201220222221201222222021012021222212200220221100222122211122211000020122222222120101220010101020122222010220222102022020220021202221002220221222222122201220122022212122222221112122222122212220222210222012111022011211121112211102122000222110121021201222002120202102112221221122210221002220122022220020201221020021210202222022122021222122202222221221221002211022001121222202222012122000222121122201002222200120212122202022221022200020212221221222210120211221122122210112222021212220222112220220220221220102010022201122212122101122222000222021021121122222121122202122002122222021222120012220020022220222220220021221201102122020012222222012201221222101220002000122020222021222122112111210221120011100120222010022220222022120221022201222022222022022202122222220220021200212122221122120222122202222220221221112112222202001221002112202220010021200120011000222101220212022212020221020221222212222222022211120210220220022212012022122102121222122220222222122221122112022001020002112011022011212121212000202011222011022200202122021222220212221202222121122212021210220221020202002022010102020222222212222220110222102002222102101102002210102102222221110011021100222001120202022012122221222221122102222220022220021200201021122212222122222122222222022221221221101220002220122220210110112211222111100021001102001110222021020122112102020222022200022102220221022102122210200220121221112122210102121122012200221221112221022010222122200011022002202100020120020112120000222210220022202002220220022210222122221120222011202211200020102200012122122122022222022202222222100220002201022210110110012002022212122121022021012110222100221000022112022220221222020022221221122102021221220220120212021022110022120202102012220222012220222210122120012100112110102101121021211010120012222100221102112112220221221202121022222022222221221200220120200200222222210112121222022202220222200221112220022021112110222122102020021220121121102021222222120011122202122220220211020012220020122112112221222120112202122122012012120102122202220221000220022222122001012200122212012020220121202122002200122201020202102122222221220220100012220022222102222201202222221211011022202122221021010212221220200220202220222011120121122022212211202221012022120120122012022100100122021220121211020112022221022102002201221220100201110222212102020021100202221220202220202122022121100222012021212201122020200120110210122020120211021122122222220222102212122220222122122202212121122210121222011222221020002000221222101222022220022010200002222202222200100122201110202222122102122021021002121220221221221012021122122001210222202022222210012122112022222222200200222220112222012211122120102111112112122002100020120020212101222220020010121200221222221201010212120021022220000212211220101220021222200002122010010210222222211120002102222212110002022202112121021222201000021202122202221101210100020221220200110022120221122202002100222121212201202022222022021111111222221122220222012110022122221211112112122100012220002202102100222102022010202211022221120201221022120120122201212201221020200210220122222212121211001202220021112022122021222010100221122111112011210120122012200022222020221110111110220221022200002022022021222000202100211212221212020122000012022210020221221022020021002100222021222112202201222012201022001220101222122211220022102112020220021221201112222010022022101111202001101201202020222002220002200020221020022220122021120201220200022111112201220020211121010200222222121221222012220222220212002022122022122221010212202202120201221221122212221010212021221020211022020020221122220221122220112110001221101020020122122020022212010020020222020211122210002001011112222102022002112110011000101200101010212202012011010102002101000220110220100122101222202201212112122011100112100210112112002002202022221";
	private static final int IMAGE_WIDE = 25;
	private static final int IMAGE_TALL = 6;

	public static void main(String[] args) {
		List <char[][]> allImages;
		allImages = putPixelsIntoImages();
		int index = findImageIndexWithFewestSymbol(allImages, '0');
		int countOneDigit = countSymbolInTheImage('1',allImages.get(index));
		int countTwoDigit = countSymbolInTheImage('2',allImages.get(index));
		System.out.println("Result: " + (countOneDigit * countTwoDigit));
	}

	private static int findImageIndexWithFewestSymbol(List<char[][]> allImages, char findSymbol) {
		int imageIndexWithFewestSymbol = 0;
		int theFewestCount = 0;
		for (int i=0; i<allImages.size(); i++) {
			int countSymbol;
			countSymbol = countSymbolInTheImage(findSymbol, allImages.get(i));
			if (i==0) {
				theFewestCount = countSymbol;
			} else {
				if (countSymbol < theFewestCount) {
					imageIndexWithFewestSymbol = i;
					theFewestCount = countSymbol;
				}
			}
		}
		return imageIndexWithFewestSymbol;
	}

	private static int countSymbolInTheImage (char findSymbol, char[][] image) {
		int countSymbol = 0;
		for (char[] imageRow : image) {
			for (char symbol : imageRow) {
				if (symbol == findSymbol) {
					countSymbol++;
				}
			}
		}
		return countSymbol;
	}

	private static List<char[][]> putPixelsIntoImages() {
		List <char[][]> allImages = new ArrayList<>();
		char[] pixels = INPUT.toCharArray();
		int rowCounter = 0;
		int columnCounter = 0;
		char[][] simpleImage = getNewSimpleImage();

		for (char pixel : pixels) {
			simpleImage[rowCounter][columnCounter] = pixel;
			if (columnCounter < IMAGE_WIDE - 1) {
				columnCounter++;
			} else {
				if (rowCounter < IMAGE_TALL - 1) {
					rowCounter++;
					columnCounter = 0;
				} else {
					allImages.add(simpleImage);
					simpleImage = getNewSimpleImage();
					rowCounter = 0;
					columnCounter = 0;
				}
			}
		}
		return allImages;
	}

	private static char[][] getNewSimpleImage() {
		return new char[IMAGE_TALL][IMAGE_WIDE];

	}

}