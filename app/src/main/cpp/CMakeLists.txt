
cmake_minimum_required(VERSION 3.4.1)


add_library(
        framesequence

        SHARED

        giflib/dgif_lib.c
        giflib/egif_lib.c
        giflib/gifalloc.c
        giflib/gif_err.c
        giflib/gif_hash.c
        giflib/openbsd-reallocarray.c
        giflib/quantize.c

        BitmapDecoderJNI.cpp
        FrameSequence.cpp
        FrameSequenceJNI.cpp
        FrameSequence_gif.cpp
        FrameSequence_webp.cpp
        JNIHelpers.cpp
        Registry.cpp
        Stream.cpp
)

add_library(libwebp SHARED IMPORTED)
set_target_properties(libwebp
        PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libwebp.so)

#libwebpdecoder
add_library(libwebpdecoder SHARED IMPORTED)
set_target_properties(libwebpdecoder
        PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libwebpdecoder.so)

#libwebpdemux
add_library(libwebpdemux SHARED IMPORTED)
set_target_properties(libwebpdemux
        PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libwebpdemux.so)

#libwebpmux
add_library(libwebpmux SHARED IMPORTED)
set_target_properties(libwebpmux
        PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../../../libs/${ANDROID_ABI}/libwebpmux.so)

include_directories(webp)

find_library( # Sets the name of the path variable.
        log-lib
        log)


target_link_libraries( # Specifies the target library.
        framesequence
        libwebp
        libwebpdecoder
        libwebpdemux
        libwebpmux
        -llog
        -ljnigraphics
        ${log-lib})