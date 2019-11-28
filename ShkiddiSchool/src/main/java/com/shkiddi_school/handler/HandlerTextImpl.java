package com.shkiddi_school.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerTextImpl implements HandlerText {



    @Override
    public List<String> findSubstringInString(String text, String pattern) {
        List<String> result = new ArrayList<>();
        if( text != null){

        Pattern p= Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);

        while (matcher.find()) {
            result.add(text.substring(matcher.start(),matcher.end()));
        }

        return result;}
        result.add("test");
        return result;
    }

    @Override
    public String processText( String text ,String pattern, String replaceStr) {
        return text.replaceAll(pattern,replaceStr);
    }




}
