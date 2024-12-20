package com.desciplineGrasser.demo;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "discipline")
public class Discipline {
    @Id
    private String id;
    private String name;
    private String icon;
    private String explain;
    private List<String> record;

    public Discipline() {}

    public Discipline(String id, String name, String icon, String explain, List<String> record) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.explain = explain;
        this.record = record;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public List<String> getRecord() {
        return record;
    }
    public void setRecord(List<String> record) {
        this.record = record;
    }
}