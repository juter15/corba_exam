package KTCosNMS;


import com.sun.corba.se.impl.corba.AnyImpl;
import lombok.ToString;
import org.omg.CORBA.*;

import org.omg.CORBA.portable.IDLEntity;

import java.io.Serializable;

/**
* KTCosNMS/EquipInfo.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from BcNNMS_AGW.idl
* 2022 11 1  6 27 59 KST
*/
@ToString
public final class EquipInfo implements IDLEntity, Serializable {
  public String equipOpCode = null;

  // OPCODE
  public String equipmentId = null;

  // ?#n? CODE
  public String managedIp = null;

  // ?#n??IP
  public String headquarterId = null;

  // ?????? CODE
  public String headquarterName = null;

  // ?????? NAME
  public String nscId = null;

  // NSC CODE
  public String nscName = null;

  // NSC NAME
  public String omcId = null;

  // ?0??? CODE
  public String omcName = null;

  // ?0??? NAME
  public String officeId = null;

  // ???? CODE
  public String officeName = null;

  // ???? NAME
  public String rssofficeId = null;

  // ?#n? ?U?? RSSOfficeCode
  public String rssofficeName = null;

  // ?#n? ?U?? RSSOffice??
  public String equipmentName = null;

  // ?#n??
  public String readCommunity = null;

  // Read Community
  public String writeCommunity = null;

  // Write Community
  public String emsIp = null;

  // ?P??????%?? ??1K/?? EMS IP
  public String equipUsageCode = null;

  // ?#n? ???? ?v(?#n?@??, SSW ?@???  ?????)
  public String classTypeCode = null;

  // ?0?r? ?@?? ?v(C4/C5)
  public String vendorCode = null;

  // ?#p? ?v
  public String modelName = null;

  // ?#nס??(?d=)
  public String modelNamesCode = null;

  // ?#nס??(?d=?v)
  public String installLocation = null;

  // ?U???
  public String addr1 = null;

  // ???
  public String degree = null;

  // (?
  public String snmpversion = null;

  // SNMP 0??B?
  public String spc = null;

  // SPC ID
  public String spcAlias = null;

  // SPC B?6
  public String equipmentName2 = null;

  // ?#n??2
  public String mainClsType = null;

  // NEMAINCLSCODE
  public String subClsType = null;

  // NESUBCLSCODE
  public String oltNesCode = null;

  // OLT ???U????v
  public String oltMstIp = null;

  // OLTMSTIP
  public String oltNeAlias = null;

  // OLT ?#???
  public String oltModelName = null;

  // OLT ?d=??
  public String oltNeUsgCode = null;

  // OLT ?#?????v
  public String rnNesCode = null;

  // RN???U????v
  public String rnNeAlias = null;

  // RN ?#???
  public String rnModelName = null;

  // RN ?d=??
  public String rnNeUsgCode = null;

  // RN ?#?????v
  public String oltLinkIp = null;

  // OLT,4PAGW ??? IP
  public int slln = (int)0;

  // AGW ???	 LLN
  public String ipsecgwIp = null;

  // IPSecGWIP
  public String trapCommunity = null;

  // Trap Community
  public String mac = null;

  // ?#n?AC?B?
  public String mgid = null;

  public EquipInfo()
  {
  } // ctor

  public EquipInfo(String _equipOpCode, String _equipmentId, String _managedIp, String _headquarterId, String _headquarterName, String _nscId, String _nscName, String _omcId, String _omcName, String _officeId, String _officeName, String _rssofficeId, String _rssofficeName, String _equipmentName, String _readCommunity, String _writeCommunity, String _emsIp, String _equipUsageCode, String _classTypeCode, String _vendorCode, String _modelName, String _modelNamesCode, String _installLocation, String _addr1, String _degree, String _snmpversion, String _spc, String _spcAlias, String _equipmentName2, String _mainClsType, String _subClsType, String _oltNesCode, String _oltMstIp, String _oltNeAlias, String _oltModelName, String _oltNeUsgCode, String _rnNesCode, String _rnNeAlias, String _rnModelName, String _rnNeUsgCode, String _oltLinkIp, int _slln, String _ipsecgwIp, String _trapCommunity, String _mac, String _mgid)
  {
    equipOpCode = _equipOpCode;
    equipmentId = _equipmentId;
    managedIp = _managedIp;
    headquarterId = _headquarterId;
    headquarterName = _headquarterName;
    nscId = _nscId;
    nscName = _nscName;
    omcId = _omcId;
    omcName = _omcName;
    officeId = _officeId;
    officeName = _officeName;
    rssofficeId = _rssofficeId;
    rssofficeName = _rssofficeName;
    equipmentName = _equipmentName;
    readCommunity = _readCommunity;
    writeCommunity = _writeCommunity;
    emsIp = _emsIp;
    equipUsageCode = _equipUsageCode;
    classTypeCode = _classTypeCode;
    vendorCode = _vendorCode;
    modelName = _modelName;
    modelNamesCode = _modelNamesCode;
    installLocation = _installLocation;
    addr1 = _addr1;
    degree = _degree;
    snmpversion = _snmpversion;
    spc = _spc;
    spcAlias = _spcAlias;
    equipmentName2 = _equipmentName2;
    mainClsType = _mainClsType;
    subClsType = _subClsType;
    oltNesCode = _oltNesCode;
    oltMstIp = _oltMstIp;
    oltNeAlias = _oltNeAlias;
    oltModelName = _oltModelName;
    oltNeUsgCode = _oltNeUsgCode;
    rnNesCode = _rnNesCode;
    rnNeAlias = _rnNeAlias;
    rnModelName = _rnModelName;
    rnNeUsgCode = _rnNeUsgCode;
    oltLinkIp = _oltLinkIp;
    slln = _slln;
    ipsecgwIp = _ipsecgwIp;
    trapCommunity = _trapCommunity;
    mac = _mac;
    mgid = _mgid;
  } // ctor


} // class EquipInfo
