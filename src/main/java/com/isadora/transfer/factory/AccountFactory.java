package com.isadora.transfer.factory;

import java.time.temporal.ChronoUnit;

import com.isadora.transfer.model.Account;

public class AccountFactory {
	
	
	public Double rateA(Account obj) {
		obj.setRate(3 + (obj.getVelue() * 0.03));
		Double rate = obj.getRate();
		return rate ;
	}
	
	public Double rateB(Account obj) {
		obj.setRate(12.00);
		Double rate = obj.getRate();
		return rate ;
	}
	
	public Double rateC(Account obj) {
		Double differenceDays = (double) ChronoUnit.DAYS.between(obj.getDateTransfer(),obj.getDateScheduled());
		 if(differenceDays > 10 && differenceDays <= 20) {
				obj.setRate(obj.getVelue() * 0.082);
				
			} else if(differenceDays > 20 && differenceDays <= 30) {
				obj.setRate(obj.getVelue() * 0.069);
				
			} else if(differenceDays > 30 && differenceDays <= 40) {
				obj.setRate(obj.getVelue() * 0.047);
				
			} else if( differenceDays > 40) {
				obj.setRate(obj.getVelue() *  0.017);
			}
		Double rate = obj.getRate();
		return rate;
	}
	
	public Double rateD(Account obj) {
		Double rate = null;
		
		if(obj.getVelue() <=1000.00) {
			rate = this.rateA(obj);
			
		} else if(obj.getVelue() > 1000.00 && obj.getVelue() <= 2000.00) {
			rate = this.rateB(obj);
			
		} else if(obj.getVelue() > 2000.00) {
			rate = this.rateC(obj);
		}
		return rate;
	}
}
