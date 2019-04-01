package com.yube.utils;

import java.util.ArrayList;

public class WordCreator {
	Thread thr;
	String alph = "abcdefghijklmnoprstuvwyzABCDEFGHIJKLMNOPRSTUVWYZ1234567890._!";
	int s;
	int t = 1;
	int i;
	ArrayList set = new ArrayList<>();
	int j;
//TODO: implements

	public ArrayList<String> creator(int numCount) {
		s = (int) Math.pow(alph.length(), numCount);
		t = 1;


		for (i = 0; i < numCount; i++) {

			s = s / alph.length();
			 charcreator2(s, t);

			t *= alph.length();

		}

		return set;
	}

//	protected String charCreate(int numCount, int s) {
//		// TODO Auto-generated method stub
//		String chs = "";
//		int loop = (int) Math.pow(alph.length(), numCount);
//
//		loop = loop / (s * numCount);
//
//		int t = 0;
//		for (int i = 0; i < alph.length(); i++) {
//			t = i;
//
//			for (int j = 0; j < loop; j++) {
//				chs += alph.charAt(t);
//			}
//			if (s > 0) {
//
//				i = 0;
//				s--;
//				t = i;
//			}
//		}
//
//		return chs;
//	

	public ArrayList<String> charcreator2(int s, int t) {
		for (int i = 0; i < alph.length() * t; i++) {
			for (int j = 0; j < s; j++) {
				if (t == 1) {
					set.add(alph.charAt(i % alph.length()));
				} else {
					set.set((i*s)+j, set.get((i*s)+j) + "" + alph.charAt(i % alph.length()));
				}
			}

		}
		return set;
	}

}
