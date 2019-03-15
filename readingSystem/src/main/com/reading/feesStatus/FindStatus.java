package com.reading.feesStatus;

public class FindStatus {

	int totalFees = 200;// from Fixed fees table
	int totalFeesPaid;// = 667;// from fees table
	double feesPerMonth;
	double feesToCompare;
	int month;
	int admissionType;// = 3;// from student table
	String joinDate;// = "20-10-2018";// from student table

	FindMonth fm = new FindMonth();

	public FindStatus(int totalFeesPaid, String admissionType, String joinDate,String totalFees) {
		this.totalFeesPaid = totalFeesPaid;
		this.admissionType = getType(admissionType);
		this.joinDate = joinDate;
		
		this.totalFees=Integer.parseInt(totalFees);
		
	}

	public String getStatus() {
		month = fm.getMonth(joinDate);
		try {
			if (month != 0) {

				feesPerMonth = (totalFees / admissionType);

				feesToCompare = totalFeesPaid / ((month + 1) * feesPerMonth);
				if (feesToCompare > 1) {
					return "PAID";
				} else {
					return "PENDING";
				}
			} else {
				feesPerMonth = (totalFees / admissionType);
				if (feesPerMonth <= totalFeesPaid) {
					return "PAID";
				} else {
					return "PENDING";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getType(String type) {
		String[] arr = type.split(" ");
		switch (arr[1]) {
		case "One":
			return 1;
		case "Three":
			return 3;
		case "Six":
			return 6;
		case "Year":
			return 12;
		default:
			return 0;
		}
	}

//	public static void main(String[] args) {
//		FindStatus f = new FindStatus(200,"for One month","01-01-2019");
//		System.out.println(f.getStatus());
//	}
}
