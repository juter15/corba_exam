package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/AdminStatusEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022년 10월 19일 수요일 오후 6시 39분 28초 KST
*/


//operStatus, ifoperstatus
public class AdminStatusEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 5;
  private static KTCosNMS.xAGWPackage.AdminStatusEnum[] __array = new KTCosNMS.xAGWPackage.AdminStatusEnum [__size];

  public static final int _UNKNOWN_ADMINSTATUS = 0;
  public static final KTCosNMS.xAGWPackage.AdminStatusEnum UNKNOWN_ADMINSTATUS = new KTCosNMS.xAGWPackage.AdminStatusEnum(_UNKNOWN_ADMINSTATUS);
  public static final int _TESTING_ADMINSTATUS = 1;
  public static final KTCosNMS.xAGWPackage.AdminStatusEnum TESTING_ADMINSTATUS = new KTCosNMS.xAGWPackage.AdminStatusEnum(_TESTING_ADMINSTATUS);
  public static final int _UNBLOCK_ADMINSTATUS = 2;
  public static final KTCosNMS.xAGWPackage.AdminStatusEnum UNBLOCK_ADMINSTATUS = new KTCosNMS.xAGWPackage.AdminStatusEnum(_UNBLOCK_ADMINSTATUS);
  public static final int _BLOCK_ADMINSTATUS = 3;
  public static final KTCosNMS.xAGWPackage.AdminStatusEnum BLOCK_ADMINSTATUS = new KTCosNMS.xAGWPackage.AdminStatusEnum(_BLOCK_ADMINSTATUS);
  public static final int _SHUTTINGDOWN_ADMINSTATUS = 4;
  public static final KTCosNMS.xAGWPackage.AdminStatusEnum SHUTTINGDOWN_ADMINSTATUS = new KTCosNMS.xAGWPackage.AdminStatusEnum(_SHUTTINGDOWN_ADMINSTATUS);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.AdminStatusEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected AdminStatusEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class AdminStatusEnum
