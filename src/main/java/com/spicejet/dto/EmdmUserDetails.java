package com.spicejet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmdmUserDetails {
    @JsonRawValue
    private Long ID;
    @JsonRawValue
    private String EmployeeCode;
    @JsonRawValue
    private String FirstName;
    @JsonRawValue
    private String LastName;
    @JsonRawValue
    private transient String DOB;
    @JsonRawValue
    private Boolean IsActive;
    @JsonRawValue
    private String Gender;
    @JsonRawValue
    private transient String PANNumber;
    @JsonRawValue
    private transient String Nationality;
    @JsonRawValue
    private transient String AdharID;
    @JsonRawValue
    private transient String CplLicenseNumber;
    @JsonRawValue
    private String PRAN;
    @JsonRawValue
    private String DepartmentID;
    @JsonRawValue
    private String DesignationID;
    @JsonRawValue
    private String email;
    @JsonRawValue
    private String DepartmentCode;
    @JsonRawValue
    private String DepartmentName;
    @JsonRawValue
    private String DepartmentDescription;
    @JsonRawValue
    private String DesignationCode;
    @JsonRawValue
    private String DesignationName;
    @JsonRawValue
    private String DesignationDescription;
    @JsonRawValue
    private String StationCode;
    @JsonRawValue
    private String StationName;
    @JsonRawValue
    private String StationZone;
    @JsonRawValue
    private String LocationName;
    @JsonRawValue
    private String SubAreaCode;
    @JsonRawValue
    private String SubArea;
    @JsonRawValue
    private transient String CostCenterCode;
 
    @JsonProperty("ID")
    public Long getID() {
        return ID;
    }

    @JsonProperty("EmployeeCode")
    public String getEmployeeCode() {
        return EmployeeCode;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return FirstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return LastName;
    }

    @JsonProperty("DOB")
    public String getDOB() {
        return DOB;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return IsActive;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return Gender;
    }

    @JsonProperty("PANNumber")
    public String getPANNumber() {
        return PANNumber;
    }

    @JsonProperty("Nationality")
    public String getNationality() {
        return Nationality;
    }

    @JsonProperty("AdharID")
    public String getAdharID() {
        return AdharID;
    }

    @JsonProperty("CplLicenseNumber")
    public String getCplLicenseNumber() {
        return CplLicenseNumber;
    }

    @JsonProperty("PRAN")
    public String getPRAN() {
        return PRAN;
    }

    @JsonProperty("DepartmentID")
    public String getDepartmentID() {
        return DepartmentID;
    }

    @JsonProperty("DesignationID")
    public String getDesignationID() {
        return DesignationID;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("DepartmentCode")
    public String getDepartmentCode() {
        return DepartmentCode;
    }

    @JsonProperty("DepartmentName")
    public String getDepartmentName() {
        return DepartmentName;
    }

    @JsonProperty("DepartmentDescription")
    public String getDepartmentDescription() {
        return DepartmentDescription;
    }

    @JsonProperty("DesignationCode")
    public String getDesignationCode() {
        return DesignationCode;
    }

    @JsonProperty("DesignationName")
    public String getDesignationName() {
        return DesignationName;
    }

    @JsonProperty("DesignationDescription")
    public String getDesignationDescription() {
        return DesignationDescription;
    }

    @JsonProperty("StationCode")
    public String getStationCode() {
        return StationCode;
    }

    @JsonProperty("StationName")
    public String getStationName() {
        return StationName;
    }

    @JsonProperty("LocationName")
    public String getLocationName() {
        return LocationName;
    }

    @JsonProperty("SubAreaCode")
    public String getSubAreaCode() {
        return SubAreaCode;
    }

    @JsonProperty("SubArea")
    public String getSubArea() {
        return SubArea;
    }

    @JsonProperty("CostCenterCode")
    public String getCostCenterCode() {
        return CostCenterCode;
    }

    @JsonProperty("StationZone")
    public String getStationZone() {
        return StationZone;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPANNumber(String pANNumber) {
        PANNumber = pANNumber;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setAdharID(String adharID) {
        AdharID = adharID;
    }

    public void setCplLicenseNumber(String cplLicenseNumber) {
        CplLicenseNumber = cplLicenseNumber;
    }

    public void setPRAN(String pRAN) {
        PRAN = pRAN;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public void setDesignationID(String designationID) {
        DesignationID = designationID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartmentCode(String departmentCode) {
        DepartmentCode = departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public void setDepartmentDescription(String departmentDescription) {
        DepartmentDescription = departmentDescription;
    }

    public void setDesignationCode(String designationCode) {
        DesignationCode = designationCode;
    }

    public void setDesignationName(String designationName) {
        DesignationName = designationName;
    }

    public void setDesignationDescription(String designationDescription) {
        DesignationDescription = designationDescription;
    }

    public void setStationCode(String stationCode) {
        StationCode = stationCode;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public void setStationZone(String stationZone) {
        StationZone = stationZone;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public void setSubAreaCode(String subAreaCode) {
        SubAreaCode = subAreaCode;
    }

    public void setSubArea(String subArea) {
        SubArea = subArea;
    }

    public void setCostCenterCode(String costCenterCode) {
        CostCenterCode = costCenterCode;
    }
}
