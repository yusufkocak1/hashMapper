package com.yube.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FileOp {
public String fileWriter(ArrayList<String> data,String path,String name);//path d�necek
public File fileReader(String path);
public String toJson(List list);//json '� d�necek
public String toXml(List list);
public String getConfig();//konfig�rasyonlar d�necek "konfig�rasyon_tagi" : "konfig�rasyon datas�",
public Object jsonStringToObject(String strJson);//
}
