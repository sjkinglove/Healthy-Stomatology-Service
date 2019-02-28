package com.haoze.dental;

import com.haoze.common.utils.ChineseCharactersCode;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Test {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        test();
    }

    public static void test() throws BadHanyuPinyinOutputFormatCombination {
        String s1=ChineseCharactersCode.getPinyinCode("新北疾控中心");
        String s2=ChineseCharactersCode.getWBCode("新北疾控中心");
        System.out.println(s1+"--"+s2);
    }
}
