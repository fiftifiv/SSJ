package com.shkiddi_school.handler;

import java.util.List;

public interface  HandlerText {

    List<String> findSubstringInString(String text , String pattern);

    String processText(String text , String pattern , String replaceStr );

}
