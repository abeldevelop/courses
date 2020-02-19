package com.abeldevelop.courses.clients.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.llave.secreta.12345";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEogIBAAKCAQEAqmddQariattOyUN3AkFnT5zpYUGMOmc6FGa7uuLYfWTirUvq\r\n" + 
			"YMT1hxeuMjCqwRD8p2Qmd1KbwFWDB2xrOHlRKlb87Y8nDt226KtAVwgwaYL0tyWU\r\n" + 
			"Cw0OckLA8JKlzWpCV6Wl4OAn+GEaL0b6oAvXAhiIQ8qFZNjMXjWHyb22DSGSsm8T\r\n" + 
			"MlPZNMEFCeYnIcqFRzwWcowH18eP1n/HNTQh5jV/qW8FxLWYRh78jSLA5NLeN/U4\r\n" + 
			"AmUXcRE/7U1l3wL56bsMLnD0qZ/tTiFNk083BH0NLCDCAfBLszPtHGPu+5g6mzEV\r\n" + 
			"6Guty/+j9WGW5+toBwfOTCemnzDZ4ku7jT2nXQIDAQABAoIBAAvzO8MDLOW5g4jx\r\n" + 
			"xkLOO2SF6If9hMwDuTr9CWVNy0jf7lWg4UrwBRf4PSsf5pmri0xh5aCwlmOim5HF\r\n" + 
			"tK89Msf5Wbt/MooEWnNurxBrbpm3qVm+tOchf0XcEJPOdPo23XgwEbX3glYU2TU/\r\n" + 
			"kQvwSJ/JAKVgaoJsAckJkABB4aaB+u9eq2HM83JaxL0H+s18iG40ohUx6NgoiBaJ\r\n" + 
			"a5MQEacoR1Qiae8ujPMwES/DHkFzcjnkyg4xRFVVFWRPUjX19vR/axjYn/p3kfG4\r\n" + 
			"HAkkdzQSYuLSbDMaOCvny/yKo8PnUSm+Ki8hS3htehPTwFmD7ERwO+WBvTWssu0m\r\n" + 
			"yN+x8rECgYEA1A9zLy0NMPnaAKeidTE3H8D4F3nSUARkRdol3YIZJLAIbicw6bxR\r\n" + 
			"VvIKFkmJ1bnZfKQu0Thp3ZLO0/JHN5HQ/SGzWt8DnfJs2qF71jn1TWLBfQRx+Sgl\r\n" + 
			"fhUGPPDckhlp7tOU6CFpWSuDlVvSqGHIO41DVQ5ZmgodZ3xcXjlbm3cCgYEAzbZH\r\n" + 
			"RHfHJQnDMkrUhqJovArGGLb/yYjlK0p4isJGnldEGfPGWW/3vjlJ59VLDFVvQvqK\r\n" + 
			"sXwJylJ7wMpp2x/043ewYGsR8Z0oIfnYKtupqBkQ9FlLeBx/iVJtamn9blffJEjf\r\n" + 
			"eB8Lix4XqAm/tzLLSk+hQI16H8ank7cpoEDJoMsCgYBookryXydgIBg6NHzLmIIb\r\n" + 
			"j+qaIsjsJI6ZjN8cIgJoANfYCkxvODVmUj057AUvyOkQQC69mzlZVAPrvmL3f2KA\r\n" + 
			"VC2cS+gL+j9NzVo+RRDNo0nXducJyo5dXOBcF3iuOg30AsA5narOjdL6UnlqDf1v\r\n" + 
			"rO8pO9BoWk9R7aHh+ClEVwKBgDcYuBPVhOgdqkNBGZUJ0MV0mUQrV20SFlc29fws\r\n" + 
			"Np/YPaw5x4lS3Ob9Dxdh4FzoUQl+c0FAOJsQ5oZncFy5PWzjNMFOTBsLfaFD+qrX\r\n" + 
			"9KPKOulHNVhxQZN1GUskIjW4oVJlljzlC8FyCOH/4nJdz2cS1tykR+5U1bNRnnuG\r\n" + 
			"frprAoGAYF8GTanUrokccEh4qyXuH7Q7GPrBanIvuc+YOsDYF8E0LGALNUnqNq0t\r\n" + 
			"dw3U6gggB5gQV9Xj3kv9QGZBRGEyzkZOYVeJkYtlP6eqZnAUrdQhPtf3UFVmUZ7A\r\n" + 
			"khYYDjhLHNl0gTbcrpKIW8Z2K2HEYifEOJahDmUBTHlWzFHn33k=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqmddQariattOyUN3AkFn\r\n" + 
			"T5zpYUGMOmc6FGa7uuLYfWTirUvqYMT1hxeuMjCqwRD8p2Qmd1KbwFWDB2xrOHlR\r\n" + 
			"Klb87Y8nDt226KtAVwgwaYL0tyWUCw0OckLA8JKlzWpCV6Wl4OAn+GEaL0b6oAvX\r\n" + 
			"AhiIQ8qFZNjMXjWHyb22DSGSsm8TMlPZNMEFCeYnIcqFRzwWcowH18eP1n/HNTQh\r\n" + 
			"5jV/qW8FxLWYRh78jSLA5NLeN/U4AmUXcRE/7U1l3wL56bsMLnD0qZ/tTiFNk083\r\n" + 
			"BH0NLCDCAfBLszPtHGPu+5g6mzEV6Guty/+j9WGW5+toBwfOTCemnzDZ4ku7jT2n\r\n" + 
			"XQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
