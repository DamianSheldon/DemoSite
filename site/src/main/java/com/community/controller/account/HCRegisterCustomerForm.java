package com.community.controller.account;

import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;

public class HCRegisterCustomerForm extends RegisterCustomerForm {

	private static final long serialVersionUID = 1103219518136287615L;
	
	public String referralCode;

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
