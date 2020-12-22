	.text
	.file	"main.7rcbfp3g-cgu.0"
	.section	.text._ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E,@function
_ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E:
.Lfunc_begin0:
	.cfi_startproc
	.cfi_personality 155, DW.ref.rust_eh_personality
	.cfi_lsda 27, .Lexception0
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	callq	_ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E
	jmp	.LBB0_2
.LBB0_1:
	movq	24(%rsp), %rdi
	callq	_Unwind_Resume@PLT
	ud2
.LBB0_2:
.Ltmp0:
	callq	_ZN4core4hint9black_box17h2438aefb3b45fad3E
.Ltmp1:
	jmp	.LBB0_3
.LBB0_3:
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB0_4:
	.cfi_def_cfa_offset 48
	jmp	.LBB0_1
.LBB0_5:
.Ltmp2:
	movq	%rax, 24(%rsp)
	movl	%edx, 32(%rsp)
	jmp	.LBB0_4
.Lfunc_end0:
	.size	_ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E, .Lfunc_end0-_ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E
	.cfi_endproc
	.section	.gcc_except_table,"a",@progbits
	.p2align	2
GCC_except_table0:
.Lexception0:
	.byte	255
	.byte	255
	.byte	1
	.uleb128 .Lcst_end0-.Lcst_begin0
.Lcst_begin0:
	.uleb128 .Lfunc_begin0-.Lfunc_begin0
	.uleb128 .Ltmp0-.Lfunc_begin0
	.byte	0
	.byte	0
	.uleb128 .Ltmp0-.Lfunc_begin0
	.uleb128 .Ltmp1-.Ltmp0
	.uleb128 .Ltmp2-.Lfunc_begin0
	.byte	0
.Lcst_end0:
	.p2align	2

	.section	.text._ZN3std2rt10lang_start17h35b0a92f0e83f522E,"ax",@progbits
	.hidden	_ZN3std2rt10lang_start17h35b0a92f0e83f522E
	.globl	_ZN3std2rt10lang_start17h35b0a92f0e83f522E
	.p2align	4, 0x90
	.type	_ZN3std2rt10lang_start17h35b0a92f0e83f522E,@function
_ZN3std2rt10lang_start17h35b0a92f0e83f522E:
	.cfi_startproc
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	leaq	.L__unnamed_1(%rip), %rax
	movq	%rdi, 32(%rsp)
	leaq	32(%rsp), %rcx
	movq	%rcx, %rdi
	movq	%rsi, 24(%rsp)
	movq	%rax, %rsi
	movq	24(%rsp), %rax
	movq	%rdx, 16(%rsp)
	movq	%rax, %rdx
	movq	16(%rsp), %rcx
	callq	*_ZN3std2rt19lang_start_internal17h142b9cc66267fea1E@GOTPCREL(%rip)
	movq	%rax, 8(%rsp)
	movq	8(%rsp), %rax
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end1:
	.size	_ZN3std2rt10lang_start17h35b0a92f0e83f522E, .Lfunc_end1-_ZN3std2rt10lang_start17h35b0a92f0e83f522E
	.cfi_endproc

	.section	".text._ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE,@function
_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movq	(%rdi), %rdi
	callq	_ZN3std10sys_common9backtrace28__rust_begin_short_backtrace17hb1f527284070d033E
	callq	_ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E
	movl	%eax, 4(%rsp)
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end2:
	.size	_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE, .Lfunc_end2-_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE
	.cfi_endproc

	.section	.text._ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E,@function
_ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E:
	.cfi_startproc
	movzbl	(%rdi), %eax
	retq
.Lfunc_end3:
	.size	_ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E, .Lfunc_end3-_ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E
	.cfi_endproc

	.section	".text._ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E,@function
_ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	_ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E
	movl	%eax, 4(%rsp)
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end4:
	.size	_ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E, .Lfunc_end4-_ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E
	.cfi_endproc

	.section	.text._ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E,@function
_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	shlq	$2, %rdx
	movq	%rdi, (%rsp)
	movq	%rsi, %rdi
	movq	(%rsp), %rsi
	callq	memcpy@PLT
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end5:
	.size	_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E, .Lfunc_end5-_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E
	.cfi_endproc

	.section	.text._ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E,@function
_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	shlq	$0, %rdx
	movq	%rdi, (%rsp)
	movq	%rsi, %rdi
	movq	(%rsp), %rsi
	callq	memcpy@PLT
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end6:
	.size	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E, .Lfunc_end6-_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	.cfi_endproc

	.section	".text._ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E,@function
_ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E:
	.cfi_startproc
	movl	(%rdi), %eax
	cmpl	(%rsi), %eax
	setl	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
	retq
.Lfunc_end7:
	.size	_ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E, .Lfunc_end7-_ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E
	.cfi_endproc

	.section	.text._ZN4core3mem4swap17h6a144576c0690c40E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3mem4swap17h6a144576c0690c40E,@function
_ZN4core3mem4swap17h6a144576c0690c40E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	_ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end8:
	.size	_ZN4core3mem4swap17h6a144576c0690c40E, .Lfunc_end8-_ZN4core3mem4swap17h6a144576c0690c40E
	.cfi_endproc

	.section	.text._ZN4core3mem7replace17h6ed822aebd77ac6bE,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3mem7replace17h6ed822aebd77ac6bE,@function
_ZN4core3mem7replace17h6ed822aebd77ac6bE:
.Lfunc_begin1:
	.cfi_startproc
	.cfi_personality 155, DW.ref.rust_eh_personality
	.cfi_lsda 27, .Lexception1
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	%esi, 4(%rsp)
.Ltmp3:
	leaq	4(%rsp), %rsi
	callq	_ZN4core3mem4swap17h6a144576c0690c40E
.Ltmp4:
	jmp	.LBB9_2
.LBB9_1:
	movq	8(%rsp), %rdi
	callq	_Unwind_Resume@PLT
	ud2
.LBB9_2:
	movl	4(%rsp), %eax
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB9_3:
	.cfi_def_cfa_offset 32
	jmp	.LBB9_1
.LBB9_4:
.Ltmp5:
	movq	%rax, 8(%rsp)
	movl	%edx, 16(%rsp)
	jmp	.LBB9_3
.Lfunc_end9:
	.size	_ZN4core3mem7replace17h6ed822aebd77ac6bE, .Lfunc_end9-_ZN4core3mem7replace17h6ed822aebd77ac6bE
	.cfi_endproc
	.section	.gcc_except_table,"a",@progbits
	.p2align	2
GCC_except_table9:
.Lexception1:
	.byte	255
	.byte	255
	.byte	1
	.uleb128 .Lcst_end1-.Lcst_begin1
.Lcst_begin1:
	.uleb128 .Ltmp3-.Lfunc_begin1
	.uleb128 .Ltmp4-.Ltmp3
	.uleb128 .Ltmp5-.Lfunc_begin1
	.byte	0
	.uleb128 .Ltmp4-.Lfunc_begin1
	.uleb128 .Lfunc_end9-.Ltmp4
	.byte	0
	.byte	0
.Lcst_end1:
	.p2align	2

	.section	".text._ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E,@function
_ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	addl	%esi, %edi
	movl	%edi, 4(%rsp)
	movl	4(%rsp), %eax
	movl	%eax, (%rsp)
	movl	(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end10:
	.size	_ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E, .Lfunc_end10-_ZN4core3num21_$LT$impl$u20$i32$GT$13unchecked_add17h530c26b26f3530e7E
	.cfi_endproc

	.section	".text._ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE,@function
_ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE:
	.cfi_startproc
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movq	(%rdi), %rdi
	callq	_ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E
	movl	%eax, 12(%rsp)
	movl	12(%rsp), %eax
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end11:
	.size	_ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE, .Lfunc_end11-_ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE
	.cfi_endproc

	.section	.text._ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E,@function
_ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E:
.Lfunc_begin2:
	.cfi_startproc
	.cfi_personality 155, DW.ref.rust_eh_personality
	.cfi_lsda 27, .Lexception2
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	%rdi, 8(%rsp)
.Ltmp6:
	leaq	8(%rsp), %rdi
	callq	_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE
.Ltmp7:
	movl	%eax, 4(%rsp)
	jmp	.LBB12_1
.LBB12_1:
	jmp	.LBB12_2
.LBB12_2:
	movl	4(%rsp), %eax
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB12_3:
	.cfi_def_cfa_offset 48
	jmp	.LBB12_4
.LBB12_4:
	movq	24(%rsp), %rdi
	callq	_Unwind_Resume@PLT
	ud2
.LBB12_5:
.Ltmp8:
	movq	%rax, 24(%rsp)
	movl	%edx, 32(%rsp)
	jmp	.LBB12_3
.Lfunc_end12:
	.size	_ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E, .Lfunc_end12-_ZN4core3ops8function6FnOnce9call_once17h6c6f00f7c5d4e0b0E
	.cfi_endproc
	.section	.gcc_except_table,"a",@progbits
	.p2align	2
GCC_except_table12:
.Lexception2:
	.byte	255
	.byte	255
	.byte	1
	.uleb128 .Lcst_end2-.Lcst_begin2
.Lcst_begin2:
	.uleb128 .Ltmp6-.Lfunc_begin2
	.uleb128 .Ltmp7-.Ltmp6
	.uleb128 .Ltmp8-.Lfunc_begin2
	.byte	0
	.uleb128 .Ltmp7-.Lfunc_begin2
	.uleb128 .Lfunc_end12-.Ltmp7
	.byte	0
	.byte	0
.Lcst_end2:
	.p2align	2

	.section	.text._ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E,@function
_ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	*%rdi
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end13:
	.size	_ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E, .Lfunc_end13-_ZN4core3ops8function6FnOnce9call_once17h8baace5ce9a1d9d2E
	.cfi_endproc

	.section	.text._ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE,@function
_ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end14:
	.size	_ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE, .Lfunc_end14-_ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE
	.cfi_endproc

	.section	.text._ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E,@function
_ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E:
	.cfi_startproc
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	$4, 32(%rsp)
	movq	32(%rsp), %rax
	movq	%rdx, 24(%rsp)
	movq	%rdi, 16(%rsp)
	movq	%rsi, 8(%rsp)
	movq	%rax, (%rsp)
	movq	(%rsp), %rax
	movq	24(%rsp), %rcx
	imulq	%rcx, %rax
	movq	16(%rsp), %rdi
	movq	8(%rsp), %rsi
	movq	%rax, %rdx
	callq	_ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end15:
	.size	_ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E, .Lfunc_end15-_ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E
	.cfi_endproc

	.section	.text._ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E,@function
_ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E:
.Lfunc_begin3:
	.cfi_startproc
	.cfi_personality 155, DW.ref.rust_eh_personality
	.cfi_lsda 27, .Lexception3
	subq	$72, %rsp
	.cfi_def_cfa_offset 80
	movb	$0, 47(%rsp)
	movq	$4, 64(%rsp)
	movq	64(%rsp), %rax
	movq	%rdi, 32(%rsp)
	movq	%rsi, 24(%rsp)
	movq	%rax, 16(%rsp)
	jmp	.LBB16_2
.LBB16_1:
	movq	48(%rsp), %rdi
	callq	_Unwind_Resume@PLT
	ud2
.LBB16_2:
	movq	16(%rsp), %rax
	cmpq	$32, %rax
	jb	.LBB16_4
	movq	32(%rsp), %rdi
	movq	24(%rsp), %rsi
	movl	$1, %edx
	callq	_ZN4core3ptr19swap_nonoverlapping17h2bdb45933e8fee45E
	jmp	.LBB16_8
.LBB16_4:
	movb	$1, 47(%rsp)
	movq	32(%rsp), %rdi
	callq	_ZN4core3ptr4read17hcb346bba70624acfE
	movl	%eax, 12(%rsp)
.Ltmp9:
	movl	$1, %edx
	movq	24(%rsp), %rdi
	movq	32(%rsp), %rsi
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E
.Ltmp10:
	jmp	.LBB16_6
.LBB16_6:
	movb	$0, 47(%rsp)
.Ltmp11:
	movq	24(%rsp), %rdi
	movl	12(%rsp), %esi
	callq	_ZN4core3ptr5write17h340395261ddffeebE
.Ltmp12:
	jmp	.LBB16_7
.LBB16_7:
	movb	$0, 47(%rsp)
	jmp	.LBB16_9
.LBB16_8:
	jmp	.LBB16_9
.LBB16_9:
	addq	$72, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB16_10:
	.cfi_def_cfa_offset 80
	movb	$0, 47(%rsp)
	jmp	.LBB16_1
.LBB16_11:
	testb	$1, 47(%rsp)
	jne	.LBB16_10
	jmp	.LBB16_1
.LBB16_12:
.Ltmp13:
	movq	%rax, 48(%rsp)
	movl	%edx, 56(%rsp)
	jmp	.LBB16_11
.Lfunc_end16:
	.size	_ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E, .Lfunc_end16-_ZN4core3ptr23swap_nonoverlapping_one17h767734ad153cd9e8E
	.cfi_endproc
	.section	.gcc_except_table,"a",@progbits
	.p2align	2
GCC_except_table16:
.Lexception3:
	.byte	255
	.byte	255
	.byte	1
	.uleb128 .Lcst_end3-.Lcst_begin3
.Lcst_begin3:
	.uleb128 .Lfunc_begin3-.Lfunc_begin3
	.uleb128 .Ltmp9-.Lfunc_begin3
	.byte	0
	.byte	0
	.uleb128 .Ltmp9-.Lfunc_begin3
	.uleb128 .Ltmp12-.Ltmp9
	.uleb128 .Ltmp13-.Lfunc_begin3
	.byte	0
.Lcst_end3:
	.p2align	2

	.section	.text._ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E,@function
_ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	andq	$-32, %rsp
	subq	$224, %rsp
	movq	$32, 200(%rsp)
	movq	200(%rsp), %rax
	movq	%rdi, 104(%rsp)
	movq	%rsi, 96(%rsp)
	movq	%rdx, 88(%rsp)
	movq	%rax, 80(%rsp)
	movq	$0, 120(%rsp)
.LBB17_2:
	movq	80(%rsp), %rax
	addq	120(%rsp), %rax
	movq	88(%rsp), %rcx
	cmpq	%rcx, %rax
	jbe	.LBB17_4
	movq	88(%rsp), %rax
	cmpq	%rax, 120(%rsp)
	jb	.LBB17_13
	jmp	.LBB17_12
.LBB17_4:
	jmp	.LBB17_6
.LBB17_6:
	leaq	128(%rsp), %rax
	movq	120(%rsp), %rsi
	movq	104(%rsp), %rdi
	movq	%rax, 72(%rsp)
	callq	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E
	movq	%rax, 64(%rsp)
	movq	120(%rsp), %rsi
	movq	96(%rsp), %rdi
	callq	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E
	movq	%rax, 56(%rsp)
	movq	64(%rsp), %rdi
	movq	72(%rsp), %rsi
	movq	80(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	movq	56(%rsp), %rdi
	movq	64(%rsp), %rsi
	movq	80(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	movq	72(%rsp), %rdi
	movq	56(%rsp), %rsi
	movq	80(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	movq	80(%rsp), %rax
	addq	120(%rsp), %rax
	movq	%rax, 120(%rsp)
	jmp	.LBB17_2
.LBB17_12:
	jmp	.LBB17_21
.LBB17_13:
	movq	88(%rsp), %rax
	subq	120(%rsp), %rax
	leaq	168(%rsp), %rcx
	movq	%rax, 48(%rsp)
	movq	%rcx, 40(%rsp)
	movq	40(%rsp), %rax
	movq	120(%rsp), %rsi
	movq	104(%rsp), %rdi
	movq	%rax, 32(%rsp)
	callq	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E
	movq	%rax, 24(%rsp)
	movq	120(%rsp), %rsi
	movq	96(%rsp), %rdi
	callq	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E
	movq	%rax, 16(%rsp)
	movq	24(%rsp), %rdi
	movq	32(%rsp), %rsi
	movq	48(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	movq	16(%rsp), %rdi
	movq	24(%rsp), %rsi
	movq	48(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	movq	32(%rsp), %rdi
	movq	16(%rsp), %rsi
	movq	48(%rsp), %rdx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hf9c8a9d742bd8ea8E
	jmp	.LBB17_21
.LBB17_21:
	movq	%rbp, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end17:
	.size	_ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E, .Lfunc_end17-_ZN4core3ptr25swap_nonoverlapping_bytes17h15bb07f3c4fc4ce8E
	.cfi_endproc

	.section	.text._ZN4core3ptr4read17hcb346bba70624acfE,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr4read17hcb346bba70624acfE,@function
_ZN4core3ptr4read17hcb346bba70624acfE:
	.cfi_startproc
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	20(%rsp), %eax
	movl	%eax, 16(%rsp)
	movq	%rdi, 8(%rsp)
	jmp	.LBB18_2
.LBB18_2:
	movq	8(%rsp), %rdi
	leaq	16(%rsp), %rsi
	movl	$1, %edx
	callq	_ZN4core10intrinsics19copy_nonoverlapping17hd2204cef49c105a2E
	movl	16(%rsp), %eax
	movl	%eax, 4(%rsp)
	movl	4(%rsp), %eax
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end18:
	.size	_ZN4core3ptr4read17hcb346bba70624acfE, .Lfunc_end18-_ZN4core3ptr4read17hcb346bba70624acfE
	.cfi_endproc

	.section	.text._ZN4core3ptr5write17h340395261ddffeebE,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr5write17h340395261ddffeebE,@function
_ZN4core3ptr5write17h340395261ddffeebE:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	%esi, (%rdi)
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end19:
	.size	_ZN4core3ptr5write17h340395261ddffeebE, .Lfunc_end19-_ZN4core3ptr5write17h340395261ddffeebE
	.cfi_endproc

	.section	".text._ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E,@function
_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE
	movq	%rax, (%rsp)
	movq	(%rsp), %rax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end20:
	.size	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E, .Lfunc_end20-_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$3add17ha6374c88e961d272E
	.cfi_endproc

	.section	".text._ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE,@function
_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE:
	.cfi_startproc
	subq	$16, %rsp
	.cfi_def_cfa_offset 24
	addq	%rsi, %rdi
	movq	%rdi, 8(%rsp)
	movq	8(%rsp), %rax
	movq	%rax, (%rsp)
	movq	(%rsp), %rax
	addq	$16, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end21:
	.size	_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE, .Lfunc_end21-_ZN4core3ptr7mut_ptr31_$LT$impl$u20$$BP$mut$u20$T$GT$6offset17h3955ed61341d140aE
	.cfi_endproc

	.section	.text._ZN4core4hint9black_box17h2438aefb3b45fad3E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core4hint9black_box17h2438aefb3b45fad3E,@function
_ZN4core4hint9black_box17h2438aefb3b45fad3E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movq	%rsp, %rax
	#APP
	#NO_APP
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end22:
	.size	_ZN4core4hint9black_box17h2438aefb3b45fad3E, .Lfunc_end22-_ZN4core4hint9black_box17h2438aefb3b45fad3E
	.cfi_endproc

	.section	".text._ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE,@function
_ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE:
	.cfi_startproc
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	%rdi, %rax
	movq	%rdi, %rcx
	addq	$4, %rcx
	movq	%rdi, 24(%rsp)
	movq	%rax, %rdi
	movq	%rcx, %rsi
	callq	_ZN4core3cmp5impls55_$LT$impl$u20$core..cmp..PartialOrd$u20$for$u20$i32$GT$2lt17hb8bbdfbb57640666E
	movb	%al, 23(%rsp)
	movb	23(%rsp), %al
	testb	$1, %al
	jne	.LBB23_3
	jmp	.LBB23_2
.LBB23_2:
	movl	$0, 32(%rsp)
	jmp	.LBB23_7
.LBB23_3:
	movq	24(%rsp), %rax
	movq	%rax, %rdi
	callq	_ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E
	movl	%eax, 16(%rsp)
	movl	16(%rsp), %edi
	movl	$1, %esi
	callq	_ZN47_$LT$i32$u20$as$u20$core..iter..range..Step$GT$17forward_unchecked17hef0152f7c1043751E
	movl	%eax, 12(%rsp)
	movq	24(%rsp), %rax
	movq	%rax, %rdi
	movl	12(%rsp), %esi
	callq	_ZN4core3mem7replace17h6ed822aebd77ac6bE
	movl	%eax, 8(%rsp)
	movl	8(%rsp), %eax
	movl	%eax, 36(%rsp)
	movl	$1, 32(%rsp)
.LBB23_7:
	movl	32(%rsp), %eax
	movl	36(%rsp), %edx
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end23:
	.size	_ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE, .Lfunc_end23-_ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE
	.cfi_endproc

	.section	".text._ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E,@function
_ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E:
	.cfi_startproc
	movl	(%rdi), %eax
	retq
.Lfunc_end24:
	.size	_ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E, .Lfunc_end24-_ZN4core5clone5impls52_$LT$impl$u20$core..clone..Clone$u20$for$u20$i32$GT$5clone17h4e4979fd9a9531e8E
	.cfi_endproc

	.section	".text._ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E,@function
_ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	xorl	%edi, %edi
	callq	_ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E
	movl	%eax, 4(%rsp)
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end25:
	.size	_ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E, .Lfunc_end25-_ZN54_$LT$$LP$$RP$$u20$as$u20$std..process..Termination$GT$6report17hf9ceee4318ac6da1E
	.cfi_endproc

	.section	".text._ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E,@function
_ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E:
	.cfi_startproc
	movl	%edi, %eax
	movl	%esi, %edx
	retq
.Lfunc_end26:
	.size	_ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E, .Lfunc_end26-_ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E
	.cfi_endproc

	.section	".text._ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E","ax",@progbits
	.p2align	4, 0x90
	.type	_ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E,@function
_ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movb	%dil, 7(%rsp)
	leaq	7(%rsp), %rdi
	callq	_ZN3std3sys4unix7process14process_common8ExitCode6as_i3217hf384d5a001dacbc7E
	movl	%eax, (%rsp)
	movl	(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end27:
	.size	_ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E, .Lfunc_end27-_ZN68_$LT$std..process..ExitCode$u20$as$u20$std..process..Termination$GT$6report17hd8ecbb9f320a8e47E
	.cfi_endproc

	.section	.text._ZN4main8multiply17h78c42b75e4ac1398E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4main8multiply17h78c42b75e4ac1398E,@function
_ZN4main8multiply17h78c42b75e4ac1398E:
	.cfi_startproc
	subq	$56, %rsp
	.cfi_def_cfa_offset 64
	movl	$0, 28(%rsp)
	movl	$1, 32(%rsp)
	movl	%esi, 36(%rsp)
	movl	32(%rsp), %eax
	movl	36(%rsp), %esi
	movl	%edi, 24(%rsp)
	movl	%eax, %edi
	callq	_ZN63_$LT$I$u20$as$u20$core..iter..traits..collect..IntoIterator$GT$9into_iter17h22987ee360d36049E
	movl	%eax, 20(%rsp)
	movl	%edx, 16(%rsp)
	movl	20(%rsp), %eax
	movl	%eax, 40(%rsp)
	movl	16(%rsp), %ecx
	movl	%ecx, 44(%rsp)
.LBB28_2:
	leaq	40(%rsp), %rdi
	callq	_ZN4core4iter5range101_$LT$impl$u20$core..iter..traits..iterator..Iterator$u20$for$u20$core..ops..range..Range$LT$A$GT$$GT$4next17hd1194c7cf7be8fefE
	movl	%edx, 52(%rsp)
	movl	%eax, 48(%rsp)
	movl	48(%rsp), %eax
	movl	%eax, %ecx
	testq	%rcx, %rcx
	je	.LBB28_4
	jmp	.LBB28_9
.LBB28_9:
	jmp	.LBB28_6
.LBB28_4:
	movl	28(%rsp), %eax
	addq	$56, %rsp
	.cfi_def_cfa_offset 8
	retq
	ud2
.LBB28_6:
	.cfi_def_cfa_offset 64
	movl	24(%rsp), %eax
	addl	28(%rsp), %eax
	seto	%cl
	testb	$1, %cl
	movl	%eax, 12(%rsp)
	jne	.LBB28_8
	movl	12(%rsp), %eax
	movl	%eax, 28(%rsp)
	jmp	.LBB28_2
.LBB28_8:
	leaq	str.0(%rip), %rdi
	leaq	.L__unnamed_2(%rip), %rdx
	movq	_ZN4core9panicking5panic17h184ede6dd822ffb4E@GOTPCREL(%rip), %rax
	movl	$28, %esi
	callq	*%rax
	ud2
.Lfunc_end28:
	.size	_ZN4main8multiply17h78c42b75e4ac1398E, .Lfunc_end28-_ZN4main8multiply17h78c42b75e4ac1398E
	.cfi_endproc

	.section	.text._ZN4main4main17h2d6c3d678af9e020E,"ax",@progbits
	.p2align	4, 0x90
	.type	_ZN4main4main17h2d6c3d678af9e020E,@function
_ZN4main4main17h2d6c3d678af9e020E:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	$2, %eax
	movl	%eax, %edi
	movl	%eax, %esi
	callq	_ZN4main8multiply17h78c42b75e4ac1398E
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end29:
	.size	_ZN4main4main17h2d6c3d678af9e020E, .Lfunc_end29-_ZN4main4main17h2d6c3d678af9e020E
	.cfi_endproc

	.section	.text.main,"ax",@progbits
	.globl	main
	.p2align	4, 0x90
	.type	main,@function
main:
	.cfi_startproc
	pushq	%rax
	.cfi_def_cfa_offset 16
	movslq	%edi, %rax
	leaq	_ZN4main4main17h2d6c3d678af9e020E(%rip), %rdi
	movq	%rsi, (%rsp)
	movq	%rax, %rsi
	movq	(%rsp), %rdx
	callq	_ZN3std2rt10lang_start17h35b0a92f0e83f522E
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end30:
	.size	main, .Lfunc_end30-main
	.cfi_endproc

	.type	.L__unnamed_1,@object
	.section	.data.rel.ro..L__unnamed_1,"aw",@progbits
	.p2align	3
.L__unnamed_1:
	.quad	_ZN4core3ptr13drop_in_place17hdeceda36dea7cc1aE
	.quad	8
	.quad	8
	.quad	_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE
	.quad	_ZN3std2rt10lang_start28_$u7b$$u7b$closure$u7d$$u7d$17hdcfdba107db1768cE
	.quad	_ZN4core3ops8function6FnOnce40call_once$u7b$$u7b$vtable.shim$u7d$$u7d$17haffc34e2504ab02eE
	.size	.L__unnamed_1, 48

	.type	.L__unnamed_3,@object
	.section	.rodata..L__unnamed_3,"a",@progbits
.L__unnamed_3:
	.ascii	"main.rs"
	.size	.L__unnamed_3, 7

	.type	.L__unnamed_2,@object
	.section	.data.rel.ro..L__unnamed_2,"aw",@progbits
	.p2align	3
.L__unnamed_2:
	.quad	.L__unnamed_3
	.asciz	"\007\000\000\000\000\000\000\000\004\000\000\000\f\000\000"
	.size	.L__unnamed_2, 24

	.type	str.0,@object
	.section	.rodata.str.0,"a",@progbits
	.p2align	4
str.0:
	.ascii	"attempt to add with overflow"
	.size	str.0, 28

	.hidden	DW.ref.rust_eh_personality
	.weak	DW.ref.rust_eh_personality
	.section	.data.DW.ref.rust_eh_personality,"aGw",@progbits,DW.ref.rust_eh_personality,comdat
	.p2align	3
	.type	DW.ref.rust_eh_personality,@object
	.size	DW.ref.rust_eh_personality, 8
DW.ref.rust_eh_personality:
	.quad	rust_eh_personality
	.section	".note.GNU-stack","",@progbits
