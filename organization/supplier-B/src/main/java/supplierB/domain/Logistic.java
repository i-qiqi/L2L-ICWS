package supplierB.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logistic {
    private String id;
    private String vOrgId;
    private String vpid;
    private String vid;
    private String mOrgId;
    private String mpid;
    private String sOrgId;
    private String spid;
    private String lOrgId;
    private String lpid;
    private String wid;
    private String spName;
    private int spNumber;
    private String category; // fixed or variable rendezvous
    private String rendezvous;
    private double longitude;
    private double latitude;
    private List<String> candidatePorts;
    private String timeStamp;

}