package com.yube.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileOparations implements FileOp {

	@Override
	public String fileWriter(ArrayList<String> data, String path, String name) {
		FileWriter fw;
		BufferedWriter bw;
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		try {
			fw = new FileWriter(path + "\\" + name, true);
			bw = new BufferedWriter(fw);
			for (Object object : data) {
				bw.write(object.toString()+"\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}

		return "succes";
	}

	@Override
	public File fileReader(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXml(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object jsonStringToObject(String strJson) {
		// TODO Auto-generated method stub
		return null;
	}

}
