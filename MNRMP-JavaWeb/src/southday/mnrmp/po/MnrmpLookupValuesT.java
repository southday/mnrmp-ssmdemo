package southday.mnrmp.po;

public class MnrmpLookupValuesT {
    private Integer lookupValueId;

    private Integer lookupTypeId;

    private String lookupValueCode;

    private String meaning;

    public Integer getLookupValueId() {
        return lookupValueId;
    }

    public void setLookupValueId(Integer lookupValueId) {
        this.lookupValueId = lookupValueId;
    }

    public Integer getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(Integer lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    public String getLookupValueCode() {
        return lookupValueCode;
    }

    public void setLookupValueCode(String lookupValueCode) {
        this.lookupValueCode = lookupValueCode == null ? null : lookupValueCode.trim();
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning == null ? null : meaning.trim();
    }
}