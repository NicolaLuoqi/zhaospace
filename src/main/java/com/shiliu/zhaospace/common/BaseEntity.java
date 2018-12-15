package com.shiliu.zhaospace.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author george
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2908475640374886321L;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid.hex")
    private String id;

    @Version
    private Timestamp timeVersion;

    private Boolean deleteFlg = false;

    private String createUserId;

    @CreationTimestamp
    private Timestamp createTime;

    private String updateUserId;

    @UpdateTimestamp
    private Timestamp updateTime;

}
