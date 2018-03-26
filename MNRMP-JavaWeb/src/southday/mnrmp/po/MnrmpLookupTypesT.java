package southday.mnrmp.po;

public class MnrmpLookupTypesT {
    private Integer lookupTypeId;

    private String lookupTypeCode;

    private String meaning;

    public Integer getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(Integer lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    public String getLookupTypeCode() {
        return lookupTypeCode;
    }

    public void setLookupTypeCode(String lookupTypeCode) {
        this.lookupTypeCode = lookupTypeCode == null ? null : lookupTypeCode.trim();
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning == null ? null : meaning.trim();
    }
}
