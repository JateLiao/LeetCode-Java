package com.lsj.leetcode.problemset.algorithms.notfinished.hard.on2018_07_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc PalindromePairs
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/7/13 10:33
 * @Author tianzhong
 */
public class PalindromePairs {
    /**
     * 336. 回文对
     *
     * 给定一组独特的单词， 找出在给定列表中不同 的索引对(i, j),使得关联的两个单词，例如：words[i] + words[j]形成回文。
 
     示例 1:
     给定 words = ["bat", "tab", "cat"]
     返回 [[0, 1], [1, 0]]
     回文是 ["battab", "tabbat"]
 
     示例 2:
     给定 words = ["abcd", "dcba", "lls", "s", "sssll"]
     返回 [[0, 1], [1, 0], [3, 2], [2, 4]]
     回文是 ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 
     贡献者:
     特别感谢 @dietpepsi 添加这个问题并提供所有的测试用例。
 
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String[] str = {"bchcfehaiaajbibjeh","b","abfcgcgechbci","eiefcgaedcg","iccci","diaijheecaied","idgc","iighhebjia","f","fbhgggfgj","daddiidfahi","fbafdbfcjbgifbeg","hag","iaedbjfhff","agigcfajfgbijc","ea","idacbjda","ffgcbhgaghgcfj","hcagid","ajdadjefejbeh","bdbgjd","dhdcjghahc","djacchdgebcgehjfgjfj","ggaaicg","gj","cbdcgfbijdihjgj","aghaicgchaiij","idajacfbabhigaa","jdgechbggeddjdc","jjdjdihhdjfafff","jghfhi","aih","bf","digdgfhfdgjjgdc","baf","daiadgeagjbibih","cidjbdgjafibbejbbic","caaecgbecegdfiegbeii","icchgffd","jbcjajadgjcgaiabjgfd","fcebbgahjieiicegaicc","gdeg","gehfchfebbdegaahifeg","cfbaibeiicd","idjdbahdagjiiaeff","ghjca","dfgabheifhffa","ecfeefiicihg","bjfjaefffdgaaefaaebh","cjf","gdbgce","cdihdcdadechhejbhidg","dfhgdgjfjeigfgca","idcjhgicihebabbjj","fbegafiha","jaadeede","ffefjjdfdccfgicgiih","jfcaibgf","g","jjacejd","ib","ifiejbcfgjcefbajif","ehbgcghhaicj","bejd","ifeagedcegefbhb","ccjcbbjdeb","fabaee","aighgdffcch","bjchjgfbh","gfjgeeeehafgj","egcafchgbg","hfabbaabjghfeagadh","cacejai","fjieabfdhjjjccge","diaeafjjcheb","dd","fbfhggbbjhgcdbeab","gffhaahg","feicdb","gejbfhjfchhefcie","ahdbcb","jie","eadagjbfhgf","dajcdigeaia","ifiba","ihhhgj","fafdbfbaefffhaccajh","hicdecgbaacefch","efdddjacacc","dcaddfcejiahfdjieea","ebcceejcbjfa","cgij","gihhjjbeidadcggbddc","ififggggbgfghidd","jefiecejjhjf","gdc","fjaifddeihdeeahae","dhbdbfhgjjcc","jidihhafbgcd","bjhhgdbijhjgacebid","cgjbedadajicjedfg","jae","hjjeaghfjg","gjhggaigcdj","eehbadeieigicg","dgffcfg","daefgh","def","ji","jecgijhcdjhgbjgjdejd","ebgbcigah","jhije","hjadadgffac","dbajjfigfhigcaebheba","hjgi","fchbidbbfb","hgbeigfdid","ffbfebhbdhjidcb","cgfdgdaffbgchgc","acbg","gaifbgjhbcjhcfij","bafbh","bagd","cibbihhbdaghdhfajcf","e","cfgafaich","cifgddbibbd","jhadg","jcbjefjc","ehahcbhfdiecjeja","gehgbfjbccg","jbibjcfdh","baiafgdfejjhd","idicfjaiaiabbiacfjgh","efccfgcg","ia","fgdad","dijcfddaafehffbgf","ahibgaaeebh","diefidijhbhbiagg","ejedbicfifcg","fe","ajacebfjgaddedhaaf","fdbjiccbfaaej","dhgg","egdidaeai","adhgiihdedicjfdehaia","cciehcgb","d","agdgieidbhgeeghieed","aa","daiajfdediagii","gidcacdfchdhfffjfbb","ciiefdjddjdfjfaj","ahjicijeidaghbabdci","ecdjhaefa","dbcfdicjaja","cgchfjbecgaica","hfehgag","jiebba","hdjfcbcjfejfdf","a","ejjacigaciabe","fhadidbdbcgcbjdfff","cefabgabgcbcdcghab","iijjdcfccegfbffijhjj","gicc","acdgabefiacagfjj","jeagjdgbhjcjichcfia","efg","baheidjhiigd","fgfbfjfdcegahjigehi","ciijbadgiab","jiejfdjgfgeddighja","ageadfhbhbdagdj","icigbfcedaifa","jedgd","ibefh","aihdf","h","jjceedjbedeefhcj","jidecahidhbfagfdi","jfbbdaddjicaefb","fijadafecah","hhiaecchcfjfbdchahb","eaeifbbgbifhfajc","bacdccccafdiac","dhce","ghgaciaijaaggf","hgjfaagbebfefaed","c","cggdahhgcdbiiabeja","ae","dfdghfghefggie","cijbbibahhjgjgggejcd","cabddde","egfiha","bjjgdffedifadgdeh","ifiiiaj","dbbecjbcb","bgheihchffg","ecffhfaaggegiaj","bjajhfjjajd","dhhgiach","dhieagagfhgbcjhdd","cjabdc","iiihihhdaghcd","bceeffjagchfacdecge","igicgggajjeeeii","ieiighhjjjbdgb","iacaaggibagcig","bhgggcfhd","gbiecffeccfchegea","gcbjf","fjdffjedcaifdffhaa","djajf","fgbgja","aaid","aiidahjaj","ddfiehbbbba","hafche","icaagch","cifjec","dhchghf","bhdegahijbgjafgb","bihjciibgj","eiej","aeijdga","eejcgjhjajfaeaj","jjbiageg","ejabjfhghfcja","hdjjhe","eabbbbcbcfedecaeb","jh","jjbdhicigaciagg","gigjfgbj","diaffbf","fhfaaijbjdceeaajd","ghagji","ighefbhjiijedff","fhd","eagcgdgig","edjbdjdbfe","eeffbjjchj","dagccfgcjgjigcaid","ibdafbedhdj","cefjejjedjdbcaejabd","bb","hiiiiebeaejbfiica","bbcea","ab","aaccbhbjghgeef","iddbdddghfbdcdhifj","igjbabddgeddcjjafaa","adecbadddj","dcbfffjjdaigibig","iichgcajdbiiie","ebdjdjiejeegi","hbabhdiihgchhbjj","jdggdejegebbahdf","ai","hcgjeeggadeccca","bfdjaceiegbcjfjc","ihcacegbdcc","bafi","ihbgcjaaggefbjdjd","ciihadhbagihbafcb","habfhagdfbjh","hgdggccecfgjgigb","eigebefahdfdihf","bhg","fajfabdedabe","abedcjhb","iicjadf","aihcfbdefhhaiegaccie","ehajc","gfediahah","behjcaafccggecgiic","babffia","afdhdcbiffa","icfcfj","hcbffghiaaa","acefbfggg","hg","fbihacadeadibh","ihjfgcgjjigcd","beffiihhceddgbhgjcg","hhdcdfhaehidbghajbdh","debgeejbh","ahcbh","cagefihe","jfggbhbhcebibiahea","febagdhgiefbfbec","ddcifhhbjachafgeeg","jaadijbiebfdbeibeje","fgjhdabghjce","fhicfg","jfdcbhachhg","acfejfggi","cj","hfjbbb","hgggjggff","jefeffcffddiic","cedaefighhfggjghjgdb","bihhhc","ieacgjjbgjifca","aaibfbhgeicca","acifbfgaihii","baddafg","fhajfec","ihffbhddajcce","jhefcdiiheghgcj","degjcgah","dde","jaabfdjhadaif","gba","hfebaaib","fgecefcghdh","jjgi","hdfchjgdjbcjfehc","fhfeaeig","fgdcibbjafdaf","agchicajgjdgaibadfb","gfehbf","ichcbebhgjcghhihi","bigciceiad","ebdiejehiabbgcc","jedjjfdhcicf","geijjbjjdiifcc","hhceddceghjgfebfbf","gffjbbcgfaefcgcge","jigbb","je","aaicdjcfjbh","jdidcgde","dhbdjcbfgjaagabb","bacfjcbiec","fceihggahacffbhf","jgjdjg","hgccfdbbjdjbfjecfdia","bfhhbjfijdhaicih","bjjdjjjhebhfgjeagef","caji","daaidgjedfcj","efdhf","eaihabgcahafaabg","jfhebfjghaabhfjhcahh","ag","ajfbacfbdbedii","fjgijffhcjffj","dea","ddahaiage","iicdjabigggjhe","ieghaihjibj","bdj","cbidbcehdg","aibiihfeg","ee","jgi","bdcjabeccjgheb","hhbj","fafdfhajjjeabcfcgdie","hhehja","agdcfdfjh","fafa","afghddadcfbjbcifgh","jibj","bbacfg","bbadffaee","dicjhbidi","gh","jbajigbfeagheegjdaa","aicbedbah","dcfdjiaeccgbajfjgea","iaahhcchbgfgejjhfehc","cecdgjfjedfjhcc","faehaibidhcebcfcb","hd","hddeegbccdadbjfjb","bdjadjifj","aacaehbacieij","acigdbgbh","cjjjjhjcfi","gfbihbdfe","gijcficfi","fhefedgchhhfdcgcjie","igbbcddfjadahajdjc","bceagahcfdghjj","jdcja","abbd","hhadcbihcae","abdhib","dbaidecejchbih","fbaccdajcbfij","fdcdjaddafbgj","dcci","i","aheecai","egcghfjb","ggedfbg","ecjeafhffcfjjfcc","gijggfediachjegbjdfe","bjdbccagchgcbcec","iejddfcfdihg","abcfhdfadijaecihgih","abebjchchjjbbe","bdehgfif","cjeijfacee","hbaadeicacccb","gfdbjgaghj","igehbcchj","jjia","caebafdgbcgcfg","ibdafihhej","eedeicegjeddaacgecd","aagbfhhfbhhbejjbjajf","bchdgcgjihaaidg","ciccadeg","gjhidcjdcffhfcef","bdcahhggeb","jffciecfjbjcebf","gbabjiajgcjhfehd","jdajfbicjggigbj","ebfga","jeejacgj","ibceidcedgghf","hiabbbijejhcigjjfi","dgaehccicahfcgic","bfaejg","daejhfgiegafciihaj","jgfcfeeeaeigfadhh","fjejdficgcbhhifbg","jhaiagdiffbadccf","ehbaihbhfccfd","hhehjdffbijcgedb","biiij","fbbbhebjfjjgddfffege","jdijj","ibfgebajj","cgadacabfhhhdacfj","hahgcjafiagajifje","if","abg","bjfjfhbbc","dcijidcajicbedeade","dejbdchchgdecji","hfafjfi","edjbbadfaghffc","eibdbebgdegcggggih","hcbgaechgdcgdbiegiaf","eeficfhhagbebjchbhff","edjcbjjbd","hihehfbaaabjgbc","beac","jcadhajfedgabhjfchaa","bhff","djjhcfcjiecjhbef","iddgjfh","fcejjfcajicj","fheigahegeaghifgf","agdcejc","dad","cdecjhabajcchebci","jjcjji","gbghghfcfdjefiiaici","hhdhdfcgcae","ecibiajjceeecgacc","heehfijaaf","cecjhbfhgc","gahheficaedicfhiicg","beefejaeabhaddbid","ah","chdcjdhg","eecjdhjhfibaifcc","aiei","dbegchjcecba","bbchffaj","j","habidjegh","icffghbeghdgecfi","ei","bfbj","egfccfdiihhibhgieff","fbajjgagihgbhegjbj","haijdgbcfgaaabefccd","ahib","ebfhebcidhae","gfchjebhbifcagdheha","eggdddaijjhfeeibfid","jij","edb","eeac","iehifcefib","bhcfihhecjffg","ejfjjfif","iccjjfgjggb","fcjebbijafj","hgbdjcdgciea","cgafdghfacf","dijbjidibdda","bcehicegfajbfj","ifcicchegbihe","ffhhg","aeehjfchhehaceaheded","ahgi","dcbafhcacfachdg","ihgaigaaae","hgicchcegjibb","egcechhiah","ggibfefibjbiha","gf","hefje","ehcffcecfeifdgfbf","bebeadfecdchheiegj","jfaiggjgb","ehhjif","ddca","edjcgbdhhjheiahi","gghhbheeee","fdjec","ja","cbgbfbdfdg","dhhhbchchcdif","ciajfggefjhifbcb","iedgj","hihchciicgibdbbihbec","jccgiijbcc","idifj","iijf","hfhibfadhcjf","ihgjhgieiijgecaaag","cdbachf","bbfhaibabgiadfgdhi","fgciifcheihh","adajhhaa","gaiegfdafgbcif","ebbicfifdhgjf","idbeigaibcdjih","hiddfcbcb","cjibcebebdacfa","fihjiecihfjbbhdfig","djedejgcgagbcgjib","bab","bdcecjdejdhegffi","gedd","fjddjbhhjj","ifgfcjcfcai","ahh","ifbhfhdejjejadadh","cd","ddhibh","hcgibciicfa","jefdjja","geegghfbbfcaeifff","giijcdh","dei","jjjiiejfdjfhcb","ebeefidgjhedeeddjg","behhhgfchicdddhfebic","hgdeiahjebee","ibbhieaiihaib","jiagegca","edejecjhc","iehc","bgjbdfafadeihgegb","jjbejad","iga","ggfcfjf","badad","hbaiidffje","fhdebfggeeadejadjaif","gbfjfegefaijbd","bihigjghi","bifeabifgfbif","ifh","hjeceefhje","ddbcihgj","edcifi","cfaacaddhaf","egj","debccccaf","ciiefhdjfdiei","ccfjdhbghicdac","hfbbhcjciei","geghaegdhj","igcbdehegebj","jddhjeaj","ibffhiaa","hbdijhbfcbfg","ecjbeijgbdfaj","fcddchgibadaghgdfe","cedach","gjeea","idffiafigdbhaa","edccj","ihgiahca","gicieaeche","jjgiiigbchbiie","ccicf","ibbbc","ead","egeedc","ajjjhajjbhb","chjj","acdbjfhdcdbfggjdab","ehjdbhicgajfgafagbc","da","faaegbi","gdbbeajjiejdhijef","ggdbbhjjaibf","ffej","effgebjeejadecij","df","jefgcdie","hicecceichiibb","cej","jfafgihdiafce","jjdbihcibii","agiigbgfdbejdd","iedaajbdcciigfdc","fecjccidgafbjbddff","dhfejdeccihb","cgffagcafceib","ihifihf","jdibafaejdjb","jeigdgeei","iehdehhccfchbbhgcejj","effbhfihac","iiafgada","ebdgeggigcfgbiabg","ehbidfji","jcbjid","cihfecddbabgjj","jdgidjeiegfjhh","ghfgbcghbidhjgegfa","jdbefebhjefgbbdih","aacahh","fjci","cebcddiihbeg","bfajdgahdifbdbfchidc","iafjjejehhdghidjfbb","feaaicecedefcdjff","ihf","ibhebfighfjbbbcge","cjhaddgdhidbgefdege","bbcgdgabddjhc","jbeabgcffcei","eg","didaafcdehgbba","biifijf","ajecbaefgdhff","efagdcecdijefej","ejecjfcdafa","ifjjigbicacbajbh","bhbiigbicedjai","ghcjjgfc","gfdcaceaeabjbgi","djibiccadahaeichfe","jjjeebdgbaaigfebe","aibadijjefjhechd","afjiddaidibhbjaf","gaiijeffjjbbhjehe","cec","fagd","bidga","eiahehbdebcibfcj","ajgbcecfgfbacbdd","cdih","cdei","abe","dfechhhgiiibj","biijaeehjei","ecaiadjgadbcbijidfi","aibjgaachiadge","eccgbbadddfidifgbaa","dicbbjiedeiafehebgih","edeaeihjib","gddiac","aeadjiecia","abjehchdbbddjgichjib","gbbbg","hbbcfcfdhjide","jdfiiefjjjhgaifebd","jabbffeag","bagihjaecifgbdfgjf","hiac","fcjafjdiagfce","difjbedficc","ggijgegagcijjdh","ihihg","echjbjdaejjbdi","afhijjd","idigc","gehfgbg","agghaggbfdega","dhiddchjbdgccdiicb","ifcc","jfjd","fdagciafieidibjbd","jifbjdhcdgbchhc","bba","cfiffifbiaiic","ced","cbeeahdhfefebeicbbh","ebaifidc","ghach","ccedjfeefieaahcihc","hfhbgiicijffj","ijchegejhgcgcfc","gfbagghgejdijgge","hfghjffee","acicfjifjj","ehfca","fhabgddc","heifhfgahfefjbccafaj","ebfaibii","aghggjgbdejigbgjfga","gjaj","gficdc","ififeajgicgdgi","iaiaigihhi","ejdbdacaccbaaghidi","ijigefdjaaeaijhbga","dgdgcfciaghi","ddgcaba","fa","bhfgifghc","bfc","jfdjaabc","ecihfdaajjcd"};
        System.err.println("测试数据：" + str.length);
        long s = System.currentTimeMillis ();
        List<List<Integer>> values = new PalindromePairs ().palindromePairs (str);
        System.err.println("结果：");
        for (List<Integer> val: values) {
            System.out.println(val);
        }
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        if (null == words || words.length < 1) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int wlen = words.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wlen; i++) {
            for (int j = 0; j < wlen; j++) {
                if (i == j) {
                    continue;
                }
                builder.setLength(0);
                String word = builder.append(words[i]).append(words[j]).toString();
                if (isPalindrome(word)) {
                    List<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(j);
                    result.add(element);
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String word) {
        if (word.length() == 1) {
            return true;
        }
        int len = word.length() / 2; // word.length() % 2 == 0 ? word.length() / 2 : word.length() / 2 + 1;
        char[] chars = word.toCharArray();
        int allLen = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] != chars[allLen - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    
    class TrieNode {
        int id = -1;
        
        
    }
}
