# kotlin-convenience-store-precourse

### 기능 목록

- 상품 목록
    - 파일에서 상품 목록을 읽어온다.
    - 각 상품은 프로모션 재고와 일반 재고가 존재한다.
    - 읽어온 상품 목록에 프로모션 재고는 존재하지만 일반 재고가 존재하지 않는 경우에는 일반 재고를 0으로 설정하여 상품 목록을 업데이트한다.
    - 업데이트한 상품 목록을 파일에 저장한다.
- 상품
    - 상품은 이름, 가격, 재고 수량, 프로모션을 가진다.
    - 상품의 프로모션은 없을 수도 있는데 이것은 일반 재고를 의미한다.
- 프로모션
    - 프로모션은 이름, 구매 수량, 증정 수량, 시작 날짜, 종료 날짜를 가진다.
- 출력
    - 편의점 환영 인사를 출력한다.
    - 보유하고 있는 상품을 안내하는 메시지를 출력한다.
    - 최신 상품 목록을 출력한다.
    - 구매할 상품명과 수량 입력 안내 메시지를 출력한다.
    - 프로모션 혜택에 대한 안내 메시지를 출력한다.
    - 프로모션 재고 부족에 대한 안내 메시지를 출력한다.
    - 멤버십 할인 적용 여부 입력 안내 메시지를 출력한다.
    - 영수증 : 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력한다.
    - 추가 구매 여부 입력 안내 메시지를 출력한다.
- 입력
    - 사용자에게 구매할 상품명과 수량을 입력받는다.
        - 사용자가 잘못된 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.
            - 구매할 상품과 수량 형식이 올바르지 않은 경우
            - 존재하지 않는 상품을 입력한 경우
            - 구매 수량이 재고 수량을 초과한 경우
            - 기타 잘못된 입력의 경우
    - Y 혹은 N을 다음과 같은 경우에 입력받는다.
        - 프로모션 적용 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 그 수량만큼 추가 여부
        - 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부
        - 멤버십 할인 적용 여부
        - 추가 구매 여부
        - 사용자가 Y 혹은 N 이외의 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.

### 실행 시나리오

1. 편의점 환영 인사 후 상품 목록을 출력한다.
2. 사용자에게 구매할 상품명과 수량을 입력받는다.
    1. 사용자가 잘못된 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.
    2. 예외 상황은 다음과 같다.
        1. 구매할 상품과 수량 형식이 올바르지 않은 경우
        2. 존재하지 않는 상품을 입력한 경우
        3. 구매 수량이 재고 수량을 초과한 경우
        4. 기타 잘못된 입력의 경우
3. 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 그 수량만큼 추가 여부를 입력받는다.
    1. Y: 증정 받을 수 있는 상품을 추가한다.
    2. N: 증정 받을 수 있는 상품을 추가하지 않는다.
    3. 사용자가 Y 혹은 N 이외의 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.
4. 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부를 입력받는다.
    1. Y: 일부 수량에 대해 정가로 결제한다.
    2. N: 정가로 결제해야하는 수량만큼 제외한 후 결제를 진행한다.
    3. 사용자가 Y 혹은 N 이외의 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.
5. 멤버십 할인 적용 여부를 입력 받는다.
    1. Y: 멤버십 할인을 적용한다.
    2. N: 멤버십 할인을 적용하지 않는다.
    3. 사용자가 Y 혹은 N 이외의 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.
6. 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력한다.
7. 추가 구매 여부를 입력 받는다.
    1. Y: 재고가 업데이트된 상품 목록을 확인 후 추가로 구매를 진행한다.
    2. N: 구매를 종료한다.
    3. 사용자가 Y 혹은 N 이외의 값을 입력한 경우 에러 메시지를 출력하고 다시 입력받는다.

### 실행 결과 예시

```
안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 10개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 5개
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[콜라-3],[에너지바-5]

멤버십 할인을 받으시겠습니까? (Y/N)
Y 

==============W 편의점================
상품명		수량	금액
콜라		3 	3,000
에너지바 		5 	10,000
=============증	정===============
콜라		1
====================================
총구매액		8	13,000
행사할인			-1,000
멤버십할인			-3,000
내실돈			 9,000

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
Y

안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 7개 탄산2+1
- 콜라 1,000원 10개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 재고 없음
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[콜라-10]

현재 콜라 4개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
Y

멤버십 할인을 받으시겠습니까? (Y/N)
N

==============W 편의점================
상품명		수량	금액
콜라		10 	10,000
=============증	정===============
콜라		2
====================================
총구매액		10	10,000
행사할인			-2,000
멤버십할인			-0
내실돈			 8,000

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
Y

안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.

- 콜라 1,000원 재고 없음 탄산2+1
- 콜라 1,000원 7개
- 사이다 1,000원 8개 탄산2+1
- 사이다 1,000원 7개
- 오렌지주스 1,800원 9개 MD추천상품
- 오렌지주스 1,800원 재고 없음
- 탄산수 1,200원 5개 탄산2+1
- 탄산수 1,200원 재고 없음
- 물 500원 10개
- 비타민워터 1,500원 6개
- 감자칩 1,500원 5개 반짝할인
- 감자칩 1,500원 5개
- 초코바 1,200원 5개 MD추천상품
- 초코바 1,200원 5개
- 에너지바 2,000원 재고 없음
- 정식도시락 6,400원 8개
- 컵라면 1,700원 1개 MD추천상품
- 컵라면 1,700원 10개

구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])
[오렌지주스-1]

현재 오렌지주스은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
Y

멤버십 할인을 받으시겠습니까? (Y/N)
Y

==============W 편의점================
상품명		수량	금액
오렌지주스		2 	3,600
=============증	정===============
오렌지주스		1
====================================
총구매액		2	3,600
행사할인			-1,800
멤버십할인			-0
내실돈			 1,800

감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)
N
```