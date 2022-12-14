package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/SeverityEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class SeverityEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 6;
  private static KTCosNMS.xAGWPackage.SeverityEnum[] __array = new KTCosNMS.xAGWPackage.SeverityEnum [__size];

  public static final int _UNKNOWN_SEVERITY = 0;
  public static final KTCosNMS.xAGWPackage.SeverityEnum UNKNOWN_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_UNKNOWN_SEVERITY);
  public static final int _CRITICAL_SEVERITY = 1;
  public static final KTCosNMS.xAGWPackage.SeverityEnum CRITICAL_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_CRITICAL_SEVERITY);
  public static final int _MAJOR_SEVERITY = 2;
  public static final KTCosNMS.xAGWPackage.SeverityEnum MAJOR_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_MAJOR_SEVERITY);
  public static final int _MINOR_SEVERITY = 3;
  public static final KTCosNMS.xAGWPackage.SeverityEnum MINOR_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_MINOR_SEVERITY);
  public static final int _NOTHING_SEVERITY = 4;
  public static final KTCosNMS.xAGWPackage.SeverityEnum NOTHING_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_NOTHING_SEVERITY);
  public static final int _CLEAR_SEVERITY = 5;
  public static final KTCosNMS.xAGWPackage.SeverityEnum CLEAR_SEVERITY = new KTCosNMS.xAGWPackage.SeverityEnum(_CLEAR_SEVERITY);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.SeverityEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected SeverityEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class SeverityEnum
