package com.smhrd.model;

public class MemberVO {
   
   private String t_id;
   private String t_pw;

   
   public MemberVO(String id, String pw) {
      this.t_id = id;
      this.t_pw = pw;

   }
   public String getId() {
      return t_id;
   }
   public String getPw() {
      return t_pw;
   }
}