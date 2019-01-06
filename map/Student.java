package map;

public class Student {
	
	private String stuId;
	
	private String name;
	
	private float score;
	
	
	public Student() {
	}

	public Student(String stuId, String name, float score) {
		this.stuId = stuId;
		this.name = name;
		this.score = score;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			if(stuId!=null) {
				return stuId.equals(((Student)obj).getStuId());
			}
		}
		return false;
	}


}
