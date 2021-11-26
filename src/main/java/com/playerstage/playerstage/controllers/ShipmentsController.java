package com.playerstage.playerstage.controllers;

import java.util.*;
import com.playerstage.playerstage.dto.*;
import com.playerstage.playerstage.models.*;
import com.playerstage.playerstage.services.ShipmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;

@Api(tags="運送方式")
@RequestMapping("/shipments")
@RestController
public class ShipmentsController {

    @Autowired
    ShipmentsService shipmentsService;

    @GetMapping("/{productUUID}")
    @Operation(summary = "依商品UUID取得運送方式")
    public ResponseEntity<?> findShipmentsByProductUUID(
        @PathVariable(name = "productUUID", required = true) String productUUID
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shipmentsService.getShipmentsByProductUUID(productUUID));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }


}
