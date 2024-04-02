import java.util.HashSet;

public class KarakterBulma {

    public static HashSet<Character> benzersizKarakterleriBul(String metin) {
        String[] kelimeler = metin.split("\\s+"); // Metni kelimelere ayır

        // Metin boyunca tüm karakterlerin tekrar edilebilirliğini kontrol et
        for (int i = 0; i < metin.length(); i++) {
            for (int j = i + 1; j < metin.length(); j++) {
                if (metin.charAt(i) == metin.charAt(j)) {
                    // Eğer tekrar eden bir karakter bulunursa, iki kelimeyi bul
                    for (int k = 0; k < kelimeler.length; k++) {
                        for (int l = k + 1; l < kelimeler.length; l++) {
                            if (anagramlarMi(kelimeler[k], kelimeler[l])) {
                                // İki kelime bulundu, karakterlerin benzersiz bir kümesini döndür
                                return benzersizKarakterKumesiAl(kelimeler[k], kelimeler[l]);
                            }
                        }
                    }
                }
            }
        }
        // Eğer iki kelime bulunamazsa veya tekrar eden karakter yoksa null döndür
        return null;
    }

    private static boolean anagramlarMi(String kelime1, String kelime2) {
        // Kelimelerin anagram olup olmadığını kontrol et
        if (kelime1.length() != kelime2.length())
            return false;

        int[] sayilar = new int[256]; // ASCII karakter seti için bir array

        // İlk kelimenin karakter sayılarını artır
        for (int i = 0; i < kelime1.length(); i++) {
            sayilar[kelime1.charAt(i)]++;
        }

        // İkinci kelimenin karakter sayılarını azalt
        for (int i = 0; i < kelime2.length(); i++) {
            sayilar[kelime2.charAt(i)]--;
        }

        // Eğer tüm karakter sayıları sıfırsa, anagramdır
        for (int sayi : sayilar) {
            if (sayi != 0)
                return false;
        }
        return true;
    }

    private static HashSet<Character> benzersizKarakterKumesiAl(String kelime1, String kelime2) {
        HashSet<Character> benzersizKarakterler = new HashSet<>();
        // Her iki kelimenin karakterlerini küme olarak ekle
        for (char c : kelime1.toCharArray()) {
            benzersizKarakterler.add(c);
        }
        for (char c : kelime2.toCharArray()) {
            benzersizKarakterler.add(c);
        }
        return benzersizKarakterler;
    }

    public static void main(String[] args) {
        String metin = "Bu bir örnek metindir ve bu metin üzerinde algoritmayı test ediyoruz. metin buradadır.";
        HashSet<Character> sonuc = benzersizKarakterleriBul(metin);
        if (sonuc != null) {
            System.out.println("İki kelime bulundu ve benzersiz karakter kümesi: " + sonuc);
        } else {
            System.out.println("İki kelime bulunamadı veya tekrar eden karakter yok.");
        }
    }
}
