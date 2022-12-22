package ex;

public class car {
	String name = null;
	String type = null;
	int yearly_model = 0;
	String color = null;
	int carKm=10;
	String oktype[] = {"경유","가솔린","LPG","하이브리드","전기","수소"};
	public void savename(String a) {
		name=a;
	}
	public boolean savetype(String a) {
		for(int i=0;i<oktype.length;i++) {
			if(oktype[i].equals(a)) {
				type=a;
				return true;
			}
		}
		return false;
	}
	public void save_yearlymodel_color(int a,String b) {
		yearly_model=a;
		color=b;
	}
	public String type_retrun() {
		return type;
	}
	public void global_variable() {
		System.out.println(name+"/"+type+"/"+yearly_model+"/"+color);
	}
	public int addcarKm(int i) {
		return carKm+i;
	}
	public int equalcolor(String a) {
		if(color.equalsIgnoreCase(color)) {
			return 1;
		}else {
			return -1;
		}
	}
}
