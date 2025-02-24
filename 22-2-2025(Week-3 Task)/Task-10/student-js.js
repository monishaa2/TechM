let student = {
    NAME: "John",
    AGE: 25,
    DEPT: "ECE",
    student_details: function () {
        console.log("Student Name: " + this.NAME);
        console.log("Student Age: " + this.AGE);
        console.log("Student Dept: " + this.DEPT);
    },
    address: {
        city: "New York",
        country: "USA"
    }
};

student.updateAge = function (newAge) {
    this.AGE = newAge;
    console.log("Updated Age: " + this.AGE);
};

student.getAddress = function () {
    console.log("City: " + this.address.city);
    console.log("Country: " + this.address.country);
};


student.student_details();
student.getAddress();

student.updateAge(26);

delete student.DEPT;
delete student.getAddress;

console.log("\nAfter Removing Property and Function:");
student.student_details();

if (student.getAddress) {
    student.getAddress();
} else {
    console.log("getAddress method is removed.");
}
