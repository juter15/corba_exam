package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/ObjectTypeEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class ObjectTypeEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 14;
  private static KTCosNMS.xAGWPackage.ObjectTypeEnum[] __array = new KTCosNMS.xAGWPackage.ObjectTypeEnum [__size];

  public static final int _UNKNOWN_OBJECTTYPE = 0;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum UNKNOWN_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_UNKNOWN_OBJECTTYPE);
  public static final int _EMS_OBJECTTYPE = 1;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum EMS_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_EMS_OBJECTTYPE);
  public static final int _ACCESAGW_OBJECTTYPE = 2;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum ACCESAGW_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_ACCESAGW_OBJECTTYPE);
  public static final int _EQUIPMENTHOLDER_OBJECTTYPE = 3;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum EQUIPMENTHOLDER_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_EQUIPMENTHOLDER_OBJECTTYPE);
  public static final int _CARD_OBJECTTYPE = 4;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum CARD_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_CARD_OBJECTTYPE);
  public static final int _DEVICE_OBJECTTYPE = 5;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum DEVICE_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_DEVICE_OBJECTTYPE);
  public static final int _PORT_OBJECTTYPE = 6;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum PORT_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_PORT_OBJECTTYPE);
  public static final int _LOGICALINTERFACE_OBJECTTYPE = 7;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum LOGICALINTERFACE_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_LOGICALINTERFACE_OBJECTTYPE);
  public static final int _IPINTERFACE_OBJECTTYPE = 8;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum IPINTERFACE_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_IPINTERFACE_OBJECTTYPE);
  public static final int _POWER_OBJECTTYPE = 9;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum POWER_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_POWER_OBJECTTYPE);
  public static final int _FAN_OBJECTTYPE = 10;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum FAN_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_FAN_OBJECTTYPE);
  public static final int _PROCESSOR_OBJECTTYPE = 11;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum PROCESSOR_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_PROCESSOR_OBJECTTYPE);
  public static final int _STORAGE_OBJECTTYPE = 12;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum STORAGE_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_STORAGE_OBJECTTYPE);
  public static final int _DSP_OBJECTTYPE = 13;
  public static final KTCosNMS.xAGWPackage.ObjectTypeEnum DSP_OBJECTTYPE = new KTCosNMS.xAGWPackage.ObjectTypeEnum(_DSP_OBJECTTYPE);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.ObjectTypeEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected ObjectTypeEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class ObjectTypeEnum
