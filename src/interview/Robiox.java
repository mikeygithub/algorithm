package interview;

public class Robiox {

    /**
     * 匹配单词
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words,String chars){


        int num = 0;
        //以单词表为主
        boolean confirem = false;
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            String tmp = chars;
            for (int j = 0; j < word.length; j++) {
                if (!chars.contains(String.valueOf(word[j])))break;//不包含直接退出
                tmp = tmp.replaceFirst(String.valueOf(word[j]),"");//替换
                if (j==word.length-1){
                    num+=word.length;
                }
            }
        }

        return num;
    }

    /**
     * 有效的累加包含三个数
     * @param num
     * @return
     */
    public static boolean isAdditiveNumber(String num) {

        return false;
    }

    public static void main(String[] args) {

        String[] words = {"cat","bt","hat","tree"};

        String chars = "atach";

        int characters = countCharacters(words, chars);

        System.out.println(characters);

    }
}
