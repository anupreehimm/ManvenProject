package myspringboot.MyProject;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Resource implements UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String empName;
	private String username;
	private String password;
	private long mobileNo;
	private String email;
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resource(String empName, String username, String password, long mobileNo, String email) {
		super();
		this.empName = empName;
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	public Resource(int id, String empName, String username, String password, long mobileNo, String email) {
		super();
		this.id = id;
		this.empName = empName;
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", empName=" + empName + ", username=" + username + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
