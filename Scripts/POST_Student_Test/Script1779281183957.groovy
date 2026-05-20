import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

def response = WS.sendRequest(findTestObject('Object Repository/POST_Student'))
WS.verifyResponseStatusCode(response, 201)
WS.verifyElementPropertyValue(response, 'name', 'Nasrullah')
