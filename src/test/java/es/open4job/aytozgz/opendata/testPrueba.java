package es.open4job.aytozgz.opendata;


	import java.util.Iterator;
	import java.util.List;
	import java.util.logging.Logger;

	import es.open4job.aytozgz.opendata.modelo.dao.AparcamientoMotoDAO;
	import es.open4job.aytozgz.opendata.modelo.vo.AparcamientoMotoVO;
	import junit.framework.*;


	public class testPrueba extends TestCase
	{

	  public void testGetLstAparcamientoMoto()
	  {
	
	  } 


	  public static Test suite()
	  { 
	    return new TestSuite(testPrueba.class);
	  } // suite

	  public static void main (String[] args)
	  {
	    junit.textui.TestRunner.run(suite());
	  } // main

	} // class

