package freshworks;

public class JSONObject {
	
	String name;
	
	String age;
	
	long timecreated;

	public JSONObject(String name, String age, long timecreated) {
		super();
		this.name = name;
		this.age = age;
		this.timecreated = timecreated;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "JSONObject [name=" + name + ", age=" + age + ", time created =" + timecreated + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public long getTimetolive() {
		return timecreated;
	}

	public void setTimetolive(long timecreated) {
		this.timecreated = timecreated;
	}

}
