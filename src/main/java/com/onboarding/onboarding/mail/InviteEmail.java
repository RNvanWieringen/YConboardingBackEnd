package com.onboarding.onboarding.mail;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Invite;

public class InviteEmail extends Mail {
    public InviteEmail(Invite invite, Employee employee) throws Exception {
        super();
        super.setBody("Dear " + invite.getName() + ",\n" +
                "\n" +
                invite.getMessage() + "\n" +
                "\n" +
                "You are invited to use the following link for registering some required data and for filling in the" +
                "required forms: " + invite.getUrl() + employee.getId() + "\n" +
                "\n" +
                "Yours sincerely,\n" +
                "\n" +
                "Young Colfield");

        super.setTitle("Invitation Young Colfield Forms");
        super.addRecipient(invite.getEmail());
    }
}