package cn.elle.Model.domain;

public class Blah {
private String username;
private String date;
private String blabla;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getBlabla() {
	return blabla;
}
public void setBlabla(String blabla) {
	this.blabla = blabla;
}
@Override
public String toString() {
	return "Blah [username=" + username + ", date=" + date + ", blabla="
			+ blabla + "]";
}

}