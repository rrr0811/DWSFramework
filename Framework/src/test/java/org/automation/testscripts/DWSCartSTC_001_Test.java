package org.automation.testscripts;

import org.automation.element_repository.CellPhonesPage;
import org.automation.element_repository.ElectronicsPage;
import org.automation.element_repository.ProductDescriptionPage;
import org.automation.generic_utilities.BaseClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.automation.generic_utilities.MyListeners.class)
public class DWSCartSTC_001_Test extends BaseClass{
	
	@Test
	public void verify_user_is_able_to_add_product_to_cart() {
		
		//step1 : click on electronics link
		basepage.getElectronicsModule().click();

		
		//step2 : click on cell Phones
		ElectronicsPage electronicspage = new ElectronicsPage(driver);
		electronicspage.getCellPhonesLink().click();
		
		//step 3 : click on smart phone
		CellPhonesPage cellphonespage = new CellPhonesPage(driver);
		cellphonespage.getSmartPhoneLink().click();
		
		//step 4 : click on add to cart button
		ProductDescriptionPage pdp = new ProductDescriptionPage(driver);
		pdp.getAddToCartButton().click();
	}
}
