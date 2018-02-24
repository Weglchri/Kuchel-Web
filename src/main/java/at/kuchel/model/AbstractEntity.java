package at.kuchel.model;


import at.kuchel.util.ObjectUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Objects;


public abstract class AbstractEntity<T extends Serializable> {

    public abstract T getId();

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity<Serializable> other = ObjectUtils.cast(o);
        if (getId() == null && other.getId() == null) {
            return super.equals(o);
        } else {
            return Objects.equals(getId(), other.getId());
        }
    }

    @Override
    public int hashCode() {
        return getId() == null ? super.hashCode() : getId().hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("id", getId())
            .toString();
    }
}
