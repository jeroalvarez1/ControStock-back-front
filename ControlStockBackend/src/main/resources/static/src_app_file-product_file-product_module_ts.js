"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_file-product_file-product_module_ts"],{

/***/ 927:
/*!*************************************************************!*\
  !*** ./src/app/file-product/file-product-routing.module.ts ***!
  \*************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "FileProductPageRoutingModule": () => (/* binding */ FileProductPageRoutingModule)
/* harmony export */ });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! tslib */ 4929);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 2560);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 124);
/* harmony import */ var _file_product_page__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./file-product.page */ 3363);




const routes = [
    {
        path: '',
        component: _file_product_page__WEBPACK_IMPORTED_MODULE_0__.FileProductPage
    }
];
let FileProductPageRoutingModule = class FileProductPageRoutingModule {
};
FileProductPageRoutingModule = (0,tslib__WEBPACK_IMPORTED_MODULE_1__.__decorate)([
    (0,_angular_core__WEBPACK_IMPORTED_MODULE_2__.NgModule)({
        imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule.forChild(routes)],
        exports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule],
    })
], FileProductPageRoutingModule);



/***/ }),

/***/ 3576:
/*!*****************************************************!*\
  !*** ./src/app/file-product/file-product.module.ts ***!
  \*****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "FileProductPageModule": () => (/* binding */ FileProductPageModule)
/* harmony export */ });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! tslib */ 4929);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 2560);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 4666);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ 2508);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 3819);
/* harmony import */ var _file_product_routing_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./file-product-routing.module */ 927);
/* harmony import */ var _file_product_page__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./file-product.page */ 3363);
/* harmony import */ var _components_components_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../components/components.module */ 5642);








let FileProductPageModule = class FileProductPageModule {
};
FileProductPageModule = (0,tslib__WEBPACK_IMPORTED_MODULE_3__.__decorate)([
    (0,_angular_core__WEBPACK_IMPORTED_MODULE_4__.NgModule)({
        imports: [
            _angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule,
            _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormsModule,
            _angular_forms__WEBPACK_IMPORTED_MODULE_6__.ReactiveFormsModule,
            _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule,
            _file_product_routing_module__WEBPACK_IMPORTED_MODULE_0__.FileProductPageRoutingModule,
            _components_components_module__WEBPACK_IMPORTED_MODULE_2__.ComponentsModule
        ],
        declarations: [_file_product_page__WEBPACK_IMPORTED_MODULE_1__.FileProductPage]
    })
], FileProductPageModule);



/***/ }),

/***/ 3363:
/*!***************************************************!*\
  !*** ./src/app/file-product/file-product.page.ts ***!
  \***************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "FileProductPage": () => (/* binding */ FileProductPage)
/* harmony export */ });
/* harmony import */ var C_Users_Admin_jeroalvarez1_MyProyects_ControlStock_ControStock_back_front_ControlStock_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 1670);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! tslib */ 4929);
/* harmony import */ var _file_product_page_html_ngResource__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./file-product.page.html?ngResource */ 8858);
/* harmony import */ var _file_product_page_scss_ngResource__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./file-product.page.scss?ngResource */ 3694);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/core */ 2560);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ 2508);
/* harmony import */ var _services_file_product_service_file_product_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/file-product-service/file-product.service */ 5931);
/* harmony import */ var _controller_fileProduct_file_product_request_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../controller/fileProduct/file-product-request.service */ 9962);
/* harmony import */ var _components_alerts_alerts_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../components/alerts/alerts.service */ 6194);




/* eslint-disable @typescript-eslint/no-shadow */

/* eslint-disable @typescript-eslint/no-unused-expressions */

/* eslint-disable @typescript-eslint/member-ordering */

/* eslint-disable @typescript-eslint/ban-types */






let FileProductPage = class FileProductPage {
  constructor(fileProductService, fileProductRequestService, alertsService) {
    this.fileProductService = fileProductService;
    this.fileProductRequestService = fileProductRequestService;
    this.alertsService = alertsService;
    this.customAlertOptions = {
      header: 'Configuración de archivo',
      subHeader: 'Configure los archivos de producto',
      message: 'Seleccione el correspondiente',
      translucent: true
    };
    this.isOpenForm = false;
    this.isOpenAsignation = false;
    this.isOpenList = true;
    this.formatedFileProductList = [];
    this.codeList = [];
    this.formul();
  }

  ngOnInit() {
    this.fileProductService.triggerFileProductArray.subscribe(data => {
      this.formul();
      this.openAsignation(true);
      this.isOpenAsignation = true;
      this.fileProductList = [];
      this.fileProductList = data;
      this.fileProductNameKeys = Object.keys(this.fileProductList[0]);
    });
    this.fileProductService.triggerOpenList.subscribe(() => {
      this.isOpenForm = false;
      this.isOpenAsignation = false;
      this.isOpenList = true;
    });
  }

  formul() {
    this.newValueAsignation = new _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormGroup({
      barcode: new _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormControl('', _angular_forms__WEBPACK_IMPORTED_MODULE_6__.Validators.required),
      productName: new _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormControl('', _angular_forms__WEBPACK_IMPORTED_MODULE_6__.Validators.required),
      mark: new _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormControl(''),
      amount: new _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormControl('', _angular_forms__WEBPACK_IMPORTED_MODULE_6__.Validators.required)
    });
  }

  addNewValueAsignation() {
    var _this = this;

    return (0,C_Users_Admin_jeroalvarez1_MyProyects_ControlStock_ControStock_back_front_ControlStock_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const form = _this.newValueAsignation.value;
      const fileProduct = {
        barcode: form.barcode,
        productName: form.productName,
        mark: form.mark,
        amount: form.amount
      };
      _this.formatedFileProductList = [];

      try {
        let theMark = '';

        _this.fileProductList.forEach(i => {
          if (i[fileProduct.mark] === undefined) {
            theMark = 'Sin marca';
          } else {
            theMark = i[fileProduct.mark];
          }

          ;

          _this.formatedFileProductList.push({
            barcode: i[fileProduct.barcode],
            productName: i[fileProduct.productName],
            mark: theMark,
            amount: i[fileProduct.amount]
          });
        });

        if (typeof _this.formatedFileProductList[0].amount !== 'number') {
          yield _this.alertsService.amountNoNumber(form.amount);
        } else {
          _this.addFileProductWithCode();

          _this.fileProductList = null;
        }
      } catch (error) {
        console.log(error);
      }
    })();
  }

  addFileProductWithCode() {
    var _this2 = this;

    const listFileProdutList = [];
    this.formatedFileProductList.forEach( /*#__PURE__*/function () {
      var _ref = (0,C_Users_Admin_jeroalvarez1_MyProyects_ControlStock_ControStock_back_front_ControlStock_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (i) {
        _this2.fileProduct = {
          productName: i.productName,
          mark: i.mark,
          amount: i.amount
        };
        _this2.code = {
          id: i.barcode
        };
        listFileProdutList.push({
          fileProduct: _this2.fileProduct,
          code: _this2.code
        });
      });

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }());
    this.fileProductRequestService.newFileProductsWithCode(listFileProdutList).subscribe(() => {
      this.openFileProductList();
    });
  }

  openNewFrom(value) {
    this.isOpenList = false;
    this.isOpenAsignation = !value;
    this.isOpenForm = value;
  }

  openAsignation(value) {
    this.isOpenList = false;
    this.isOpenForm = !value;

    if (this.isOpenAsignation) {
      this.fileProductService.triggerOpenAchiveModule.emit();
    } else {
      if (!this.fileProductList) {
        this.fileProductService.triggerOpenAchiveModule.emit();
      } else {
        this.isOpenAsignation = value;
      }
    }
  }

  openFileProductList() {
    var _this3 = this;

    return (0,C_Users_Admin_jeroalvarez1_MyProyects_ControlStock_ControStock_back_front_ControlStock_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.fileProductService.triggerUpdatedFileList.emit();

      console.log('Despues');
      _this3.isOpenAsignation = false;
      _this3.isOpenForm = false;
      _this3.isOpenList = true;
    })();
  }

};

FileProductPage.ctorParameters = () => [{
  type: _services_file_product_service_file_product_service__WEBPACK_IMPORTED_MODULE_3__.FileProductService
}, {
  type: _controller_fileProduct_file_product_request_service__WEBPACK_IMPORTED_MODULE_4__.FileProductRequestService
}, {
  type: _components_alerts_alerts_service__WEBPACK_IMPORTED_MODULE_5__.AlertsService
}];

FileProductPage = (0,tslib__WEBPACK_IMPORTED_MODULE_7__.__decorate)([(0,_angular_core__WEBPACK_IMPORTED_MODULE_8__.Component)({
  selector: 'app-file-product',
  template: _file_product_page_html_ngResource__WEBPACK_IMPORTED_MODULE_1__,
  styles: [_file_product_page_scss_ngResource__WEBPACK_IMPORTED_MODULE_2__]
})], FileProductPage);


/***/ }),

/***/ 3694:
/*!****************************************************************!*\
  !*** ./src/app/file-product/file-product.page.scss?ngResource ***!
  \****************************************************************/
/***/ ((module) => {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJmaWxlLXByb2R1Y3QucGFnZS5zY3NzIn0= */";

/***/ }),

/***/ 8858:
/*!****************************************************************!*\
  !*** ./src/app/file-product/file-product.page.html?ngResource ***!
  \****************************************************************/
/***/ ((module) => {

module.exports = "<ion-header>\n  <ion-toolbar color=\"main-color\">\n    <ion-buttons slot=\"secondary\">\n\n      <ion-button (click)=\"openFileProductList()\">\n        <ion-icon name=\"list-circle\" slot=\"icon-only\"></ion-icon>\n      </ion-button>\n\n        <ion-button (click)=\"openAsignation(true)\">\n          <ion-icon name=\"arrow-down-circle\" slot=\"icon-only\"></ion-icon>\n        </ion-button>\n\n        <ion-button (click)=\"openNewFrom(true)\">\n          <ion-icon name=\"add-circle\" slot=\"icon-only\"></ion-icon>\n        </ion-button>\n    </ion-buttons>\n    <app-file-product-update></app-file-product-update> <!--Modal-->\n    <ion-title>Productos de archivo</ion-title>\n  </ion-toolbar>\n</ion-header>\n\n<ion-content>\n  <app-file-product-list *ngIf=\"isOpenList\"></app-file-product-list>\n  <app-new-file-product-with-code *ngIf=\"isOpenForm\"></app-new-file-product-with-code>\n  <ion-card *ngIf=\"isOpenAsignation\">\n    <ion-card-header>\n      <ion-card-title>Asignación de valores</ion-card-title>\n    </ion-card-header>\n    <ion-card-content>\n      <form [formGroup]=\"newValueAsignation\">\n          <ion-item>\n            <ion-label>Código de barra</ion-label>\n            <ion-select [interfaceOptions]=\"customAlertOptions\" interface=\"alert\" placeholder=\"Seleccione uno\" formControlName=\"barcode\">\n              <ion-select-option *ngFor=\"let fileProductNameKey of fileProductNameKeys\">{{fileProductNameKey}}</ion-select-option>\n            </ion-select>\n          </ion-item>\n\n          <ion-item>\n            <ion-label>Nombre</ion-label>\n            <ion-select [interfaceOptions]=\"customAlertOptions\" interface=\"alert\" placeholder=\"Seleccione uno\" formControlName=\"productName\">\n              <ion-select-option *ngFor=\"let fileProductNameKey of fileProductNameKeys\">{{fileProductNameKey}}</ion-select-option>\n            </ion-select>\n          </ion-item>\n\n          <ion-item>\n            <ion-label>Marca</ion-label>\n            <ion-select [interfaceOptions]=\"customAlertOptions\" interface=\"alert\" placeholder=\"Seleccione uno\" formControlName=\"mark\">\n              <ion-select-option *ngFor=\"let fileProductNameKey of fileProductNameKeys\">{{fileProductNameKey}}</ion-select-option>\n            </ion-select>\n          </ion-item>\n\n          <ion-item lines=\"none\">\n            <ion-label>Cantidad</ion-label>\n            <ion-select [interfaceOptions]=\"customAlertOptions\" interface=\"alert\" placeholder=\"Seleccione uno\" formControlName=\"amount\">\n              <ion-select-option *ngFor=\"let fileProductNameKey of fileProductNameKeys\">{{fileProductNameKey}}</ion-select-option>\n            </ion-select>\n          </ion-item>\n\n        <ion-button color=\"main-color\" expand=\"block\" (click)=\"addNewValueAsignation()\" [disabled]=\"newValueAsignation.invalid\">Aceptar</ion-button>\n      </form>\n    </ion-card-content>\n  </ion-card>\n</ion-content>\n";

/***/ })

}]);
//# sourceMappingURL=src_app_file-product_file-product_module_ts.js.map