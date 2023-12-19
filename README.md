# Assessment
NIQ Assessment


{
	"info": {
		"_postman_id": "f2f58a69-26f4-4205-b605-c2f140ad9c63",
		"name": "NIQ Ass",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "11087024"
	},
	"item": [
		{
			"name": "http://localhost:9902/api/product/get-products?shopperId=123456789&limit=20",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:9902/api/product/get-products?shopperId=123456789&limit=20",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9902",
					"path": [
						"api",
						"product",
						"get-products"
					],
					"query": [
						{
							"key": "shopperId",
							"value": "123456789"
						},
						{
							"key": "limit",
							"value": "20"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:9902/api/product/get-shopper?productId=BB-2144746855&limit=1",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:9902/api/product/get-shopper?productId=BB-2144746855&limit=1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9902",
					"path": [
						"api",
						"product",
						"get-shopper"
					],
					"query": [
						{
							"key": "productId",
							"value": "BB-2144746855"
						},
						{
							"key": "limit",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:9901/api/product/save",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"productId\":\"DRS089\",\r\n    \"category\":\"Dress\",\r\n    \"brand\":\"brand\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:9901/api/product/save",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9901",
					"path": [
						"api",
						"product",
						"save"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:9901/api/shopperPersonalizedProduct/save",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"shopperId\": \"RTE872\",\r\n    \"shelf\": [\r\n        {\r\n            \"productId\": \"DRS089\",\r\n            \"relevancyScore\": 0.85\r\n        },\r\n        {\r\n            \"productId\": \"BQ-2144746855\",\r\n            \"relevancyScore\": 0.92\r\n        },\r\n        {\r\n            \"productId\": \"GHI089\",\r\n            \"relevancyScore\": 0.78\r\n        }\r\n    ]\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:9901/api/shopperPersonalizedProduct/save",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9901",
					"path": [
						"api",
						"shopperPersonalizedProduct",
						"save"
					]
				}
			},
			"response": []
		}
	]
}
