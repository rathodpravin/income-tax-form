const API_URL = "http://localhost:8080/api/employee_details";

const form = document.getElementById("incomeTaxForm");


form.addEventListener("submit", async function (event) {

    event.preventDefault();


    // Get values

    const fullName =
        document.getElementById("fullName").value.trim();

    const pan =
        document.getElementById("pan").value.trim().toUpperCase();

    const dob =
        document.getElementById("dob").value;

    const gender =
        document.getElementById("gender").value;

    const parentName =
        document.getElementById("parentName").value.trim();

    const maritalStatus =
        document.getElementById("maritalStatus").value;


    const mobile =
        document.getElementById("mobile").value.trim();

    const email =
        document.getElementById("email").value.trim();

    const address =
        document.getElementById("address").value.trim();

    const city =
        document.getElementById("city").value.trim();

    const state =
        document.getElementById("state").value;

    const pincode =
        document.getElementById("pincode").value.trim();


    const incomeSource =
        document.getElementById("incomeSource").value;

    const financialYear =
        document.getElementById("financialYear").value;

    const annualIncome =
        document.getElementById("annualIncome").value;

    const tds =
        document.getElementById("tds").value;

    const otherIncome =
        document.getElementById("otherIncome").value;

    const taxRegime =
        document.getElementById("taxRegime").value;


    const accountHolder =
        document.getElementById("accountHolder").value.trim();

    const bankName =
        document.getElementById("bankName").value.trim();

    const accountNumber =
        document.getElementById("accountNumber").value.trim();

    const ifsc =
        document.getElementById("ifsc").value.trim().toUpperCase();

    const accountType =
        document.getElementById("accountType").value;


    // ==================================================
    // REQUIRED VALIDATION
    // ==================================================

    if (
        fullName === "" ||
        pan === "" ||
        dob === "" ||
        gender === "" ||
        parentName === "" ||
        maritalStatus === "" ||
        mobile === "" ||
        email === "" ||
        address === "" ||
        city === "" ||
        state === "" ||
        pincode === "" ||
        incomeSource === "" ||
        financialYear === "" ||
        annualIncome === "" ||
        taxRegime === "" ||
        accountHolder === "" ||
        bankName === "" ||
        accountNumber === "" ||
        ifsc === "" ||
        accountType === ""
    ) {

        alert("Please fill all required fields.");

        return;
    }


    // ==================================================
    // PAN VALIDATION
    // ==================================================

    const panPattern = /^[A-Z]{5}[0-9]{4}[A-Z]$/;

    if (!panPattern.test(pan)) {

        alert(
            "Please enter a valid PAN.\nExample: ABCDE1234F"
        );

        document.getElementById("pan").focus();

        return;
    }


    // ==================================================
    // MOBILE VALIDATION
    // ==================================================

    const mobilePattern = /^[6-9][0-9]{9}$/;

    if (!mobilePattern.test(mobile)) {

        alert("Please enter a valid 10 digit mobile number.");

        document.getElementById("mobile").focus();

        return;
    }


    // ==================================================
    // EMAIL VALIDATION
    // ==================================================

    const emailPattern =
        /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailPattern.test(email)) {

        alert("Please enter a valid email address.");

        document.getElementById("email").focus();

        return;
    }


    // ==================================================
    // PINCODE VALIDATION
    // ==================================================

    const pincodePattern = /^[0-9]{6}$/;

    if (!pincodePattern.test(pincode)) {

        alert("Please enter a valid 6 digit PIN code.");

        document.getElementById("pincode").focus();

        return;
    }


    // ==================================================
    // ACCOUNT NUMBER VALIDATION
    // ==================================================

    const accountPattern = /^[0-9]{9,18}$/;

    if (!accountPattern.test(accountNumber)) {

        alert("Account number must contain 9 to 18 digits.");

        document.getElementById("accountNumber").focus();

        return;
    }


    // ==================================================
    // IFSC VALIDATION
    // ==================================================

    const ifscPattern = /^[A-Z]{4}0[A-Z0-9]{6}$/;

    if (!ifscPattern.test(ifsc)) {

        alert(
            "Please enter a valid IFSC code.\nExample: SBIN0001234"
        );

        document.getElementById("ifsc").focus();

        return;
    }


    // ==================================================
    // DECLARATION
    // ==================================================

    const declaration =
        document.getElementById("declaration");

    if (!declaration.checked) {

        alert("Please agree to the declaration.");

        return;
    }


    // ==================================================
    // CREATE JSON OBJECT
    // ==================================================

    const application = {

        fullName: fullName,
        pan: pan,
        dob: dob,
        gender: gender,
        parentName: parentName,
        maritalStatus: maritalStatus,

        mobile: mobile,
        email: email,
        address: address,
        city: city,
        state: state,
        pincode: pincode,

        incomeSource: incomeSource,
        financialYear: financialYear,
        annualIncome: Number(annualIncome),
        tds: Number(tds || 0),
        otherIncome: Number(otherIncome || 0),
        taxRegime: taxRegime,

        accountHolder: accountHolder,
        bankName: bankName,
        accountNumber: accountNumber,
        ifsc: ifsc,
        accountType: accountType
    };


    console.log("Sending data:", application);


    // ==================================================
    // SEND DATA TO SPRING BOOT
    // ==================================================

    try {

        const response = await fetch(API_URL, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(application)
        });


        if (!response.ok) {

            throw new Error(
                "Server returned error: " + response.status
            );
        }


        const savedApplication =
            await response.json();


        console.log(
            "Saved Application:",
            savedApplication
        );


        // Success message

        alert(
            "Income Tax Application submitted successfully!\n\n" +
            "Application ID: " +
            savedApplication.id
        );


        // Reset form

        form.reset();


    } catch (error) {
    console.error("Error submitting application:", error);

    alert(
        "Unable to submit application.\n\n" +
        "Error: " + error.message
    );
}

});