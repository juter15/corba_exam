package KTCosNMS;


/**
* KTCosNMS/enNeType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//------------------------------------------------------------------------------------------------------
public class enNeType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 8;
  private static KTCosNMS.enNeType[] __array = new KTCosNMS.enNeType [__size];

  public static final int _NETYPE_Eocms = 0;
  public static final KTCosNMS.enNeType NETYPE_Eocms = new KTCosNMS.enNeType(_NETYPE_Eocms);
  public static final int _NETYPE_Exchange = 1;
  public static final KTCosNMS.enNeType NETYPE_Exchange = new KTCosNMS.enNeType(_NETYPE_Exchange);
  public static final int _NETYPE_Flc = 2;
  public static final KTCosNMS.enNeType NETYPE_Flc = new KTCosNMS.enNeType(_NETYPE_Flc);
  public static final int _NETYPE_FlcEms = 3;
  public static final KTCosNMS.enNeType NETYPE_FlcEms = new KTCosNMS.enNeType(_NETYPE_FlcEms);
  public static final int _NETYPE_Dslam = 4;
  public static final KTCosNMS.enNeType NETYPE_Dslam = new KTCosNMS.enNeType(_NETYPE_Dslam);
  public static final int _NETYPE_DslamEms = 5;
  public static final KTCosNMS.enNeType NETYPE_DslamEms = new KTCosNMS.enNeType(_NETYPE_DslamEms);
  public static final int _NETYPE_Agw = 6;
  public static final KTCosNMS.enNeType NETYPE_Agw = new KTCosNMS.enNeType(_NETYPE_Agw);
  public static final int _NETYPE_AgwEms = 7;
  public static final KTCosNMS.enNeType NETYPE_AgwEms = new KTCosNMS.enNeType(_NETYPE_AgwEms);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.enNeType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected enNeType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class enNeType