package zr.reactive.zinnur.rxzr.mvp.presenters.vo;

import java.io.Serializable;

/**
 * Created by Zinnur on 29.10.16.
 */

public class AbsVO implements Serializable {
    private String status;
    private String description;

    public AbsVO(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbsVO that = (AbsVO) o;

        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;
        return !(description != null ? !description.equals(that.description) : that.description != null);

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
