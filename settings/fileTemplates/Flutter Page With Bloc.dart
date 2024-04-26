import 'dart:async';
import 'dart:convert';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:firebase_analytics/firebase_analytics.dart';
import 'package:firebase_analytics/observer.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/material.dart';

import 'models/${DATA_MODEL_VAR}.dart';

void routeTo${PAGE_NAME}Page(BuildContext context, String $ARG_1) {
  Navigator.push(
    context,
    MaterialPageRoute(builder: (context) {
      FirebaseAnalytics analytics = FirebaseAnalytics();
      FirebaseAnalyticsObserver observer =
      FirebaseAnalyticsObserver(analytics: analytics);
      return ${PAGE_NAME}Page(analytics, observer, $ARG_1);
    }),
  );
}

class ${PAGE_NAME}Page extends StatelessWidget {
  const ${PAGE_NAME}Page(this.analytics, this.observer, this.$ARG_1, {Key? key})
      : super(key: key);
  final FirebaseAnalytics analytics;
  final FirebaseAnalyticsObserver observer;
  final String $ARG_1;

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
        create: (_) => ${PAGE_NAME}Bloc($ARG_1,
            repository: ${PAGE_NAME}Repository(FirebaseDatabase.instance))
          ..add(PageLoad()),
        child: _${PAGE_NAME}Page());
  }
}

class _${PAGE_NAME}Page extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<${PAGE_NAME}Bloc, ${PAGE_NAME}PageState>(
        builder: (context, ${PAGE_NAME}PageState state) {
          return Scaffold(
              appBar: AppBar(
                title: const Text("${PAGE_NAME}"),
              ),
              floatingActionButton: buildFab(state),
              body: buildBody(state));
        });
  }
}

abstract class ${PAGE_NAME}Event {}

class PageLoad extends ${PAGE_NAME}Event {}

class ${PAGE_NAME}Bloc extends Bloc<PageLoad, ${PAGE_NAME}PageState> {
  final ${PAGE_NAME}Repository _repository;

  ${PAGE_NAME}Bloc(String $ARG_1, {required ${PAGE_NAME}Repository repository})
      : _repository = repository,
        super(${PAGE_NAME}PageState()) {
    on<PageLoad>((event, emit) async {
      await fetchData($ARG_1);
      emit(state);
    });
  }

  Future<void> fetchData($ARG_1) async {
    $DATA_MODEL_TYPE $DATA_MODEL_VAR = await _repository.fetch${DATA_MODEL_TYPE}($ARG_1: $ARG_1);
    //todo transform
    state._loading = false;
  }
}

class ${PAGE_NAME}PageState {
  List<${PAGE_NAME}Row> rows = List.empty(growable: true);
  bool _loading = true;
}

class ${PAGE_NAME}Row {
}

class ${PAGE_NAME}Repository {
  ${PAGE_NAME}Repository(this.database);

  final FirebaseDatabase database;

  Future<List<${DATA_MODEL_TYPE}>> fetch${DATA_MODEL_TYPE}({required String $ARG_1}) async {
    DataSnapshot snapshot = await database.ref("${DATA_MODEL_VAR}").get();
    Map<String, dynamic> json = jsonDecode(jsonEncode(snapshot.value));
    return json.entries.map((e) => ${DATA_MODEL_TYPE}.fromJson(e.value)).toList();
  }

}