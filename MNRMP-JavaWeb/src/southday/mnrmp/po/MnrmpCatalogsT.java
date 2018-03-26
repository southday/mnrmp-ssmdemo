package southday.mnrmp.po;

public class MnrmpCatalogsT {
    private Integer catalogId;

    private String catalogName;

    private Integer parentCatalogId;

    private Integer userId;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public Integer getParentCatalogId() {
        return parentCatalogId;
    }

    public void setParentCatalogId(Integer parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
