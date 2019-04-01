package com.yube.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FileOp {
public String fileWriter(ArrayList<String> data,String path,String name);//path dönecek
public File fileReader(String path);
public String toJson(List list);//json 'ý dönecek
public String toXml(List list);
public String getConfig();//konfigürasyonlar dönecek "konfigürasyon_tagi" : "konfigürasyon datasý",
public Object jsonStringToObject(String strJson);//
}
